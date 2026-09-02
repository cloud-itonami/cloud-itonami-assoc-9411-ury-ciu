(ns association.facts-test
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :refer [deftest is testing]]
            [association.facts :as facts]))

(def ^:private authored
  "data/datascript-tx.edn is the authored copy; `catalog` is a reading of it."
  (edn/read-string (slurp "data/datascript-tx.edn")))

(deftest the-fixture-reads-a-real-catalog
  ;; Every assertion below is per-entry, so an empty catalog would satisfy all
  ;; of them. This is the floor that keeps "there was nothing to check" from
  ;; looking like "everything checked out".
  (is (pos? (count authored)))
  (is (= (count authored) (count (facts/spec-basis "ciu")))))

(deftest catalog-agrees-with-the-authored-data-file
  ;; The .cljc holds the catalog inline, the way the sibling repos do, so the
  ;; risk is transcription: a dropped field, a mistyped url, a quote that no
  ;; longer matches the one the live checker will look for. Compare field by
  ;; field rather than by count.
  (doseq [[i [a c]] (map-indexed vector (map vector authored (facts/spec-basis "ciu")))]
    (testing (str "entry " i " (" (:association-rule/id a) ")")
      (is (= (set (keys a)) (set (keys c)))
          "the same fields, neither more nor fewer")
      (doseq [k (sort (keys a))]
        (testing (str k)
          (is (= (if (= k :association-rule/topic) (set (k a)) (k a))
                 (if (= k :association-rule/topic) (set (k c)) (k c)))))))))

(deftest ciu-has-spec-basis
  (let [sb (facts/spec-basis "ciu")]
    (is (= 31 (count sb)))
    (is (every? #(str/starts-with? (:association-rule/url %) "https://") sb))
    (is (every? #(= "9411" (:association-rule/isic %)) sb))
    (is (every? #(= "URY" (:association-rule/country %)) sb))
    (is (every? #(seq (:association-rule/source-quote %)) sb)
        "an entry with no quoted span cannot be checked against its own source")
    (is (every? #(seq (:association-rule/source-article %)) sb))
    (is (= (count sb) (count (set (map :association-rule/id sb))))
        "ids are the federation's identity attribute")))

(deftest every-entry-is-dated-or-says-why-not
  ;; The point of this catalog is that a missing date is recorded, not silent.
  ;; An entry carrying both a date and a reason for having none would mean the
  ;; two had drifted apart, so that is a failure too.
  (doseq [e (facts/spec-basis "ciu")]
    (testing (:association-rule/id e)
      (let [dated? (boolean (or (:association-rule/established-date e)
                                (:association-rule/last-revised-date e)))
            excused? (boolean (:association-rule/date-unknown-because e))]
        (is (or dated? excused?) "needs a date or a recorded reason for having none")
        (is (not (and dated? excused?))
            "a reason for having no date does not belong on an entry that has one")
        (when excused?
          (is (keyword? (:association-rule/date-unknown-because e)))))
      (is (keyword? (:association-rule/url-provenance e))))))

(deftest the-founding-fact-is-corroborated-off-ciu
  ;; The founding date is the one fact this catalog held before it could read
  ;; CIU's own instruments. It rests on three documents, one of which is not
  ;; CIU's: assert that the independent one is actually cited as a URL rather
  ;; than only named in prose, which is how it stood until 2026-09-02.
  (let [by-id (into {} (map (juxt :association-rule/id identity))
                    (facts/spec-basis "ciu"))
        own (get by-id "ciu.founding-1898-11-12")
        parl (get by-id "ciu.founding-corroborated-parlamento")
        art1 (get by-id "ciu.constitution-art-1")]
    (doseq [e [own parl art1]]
      (is (some? e))
      (is (= "1898-11-12" (:association-rule/established-date e))))
    (is (str/includes? (:association-rule/url parl) "parlamento.gub.uy")
        "the corroborating source must not be CIU itself")
    (is (= :official-ciu-com-uy-estatutos (:association-rule/url-provenance art1))
        "and one of the three must be the constitutive instrument")))

(deftest the-estatutos-are-read-article-by-article
  ;; A catalog that cites one page of an instrument once is not reading the
  ;; instrument. Assert that the Estatutos entries name distinct articles.
  (let [est (filter #(= :official-ciu-com-uy-estatutos
                        (:association-rule/url-provenance %))
                    (facts/spec-basis "ciu"))
        arts (map :association-rule/source-article est)]
    (is (< 10 (count est)))
    (is (< 10 (count (distinct arts))))
    (is (every? #(re-matches #"\d+" %) arts)
        "an Estatutos entry cites a numbered article")
    (doseq [e est]
      (is (str/includes? (str/lower-case (:association-rule/title e))
                         (str "article " (:association-rule/source-article e)))
          "the title must name the article, so prose and citation cannot drift"))))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "ibec")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["ciu" "ibec"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ibec"] (:missing-associations c)))))

(deftest by-topic-filters
  (let [n (fn [t] (count (facts/by-topic "ciu" t)))]
    (is (= 22 (n :governance)))
    (is (= 7 (n :membership)))
    (is (= 4 (n :finance)))
    (is (= 4 (n :ethics)))
    (is (empty? (facts/by-topic "ciu" :labor)))
    (is (empty? (facts/by-topic "ibec" :governance)))
    (is (= (count (facts/spec-basis "ciu"))
           (count (distinct (mapcat #(map :association-rule/id (facts/by-topic "ciu" %))
                                    [:governance :membership :finance :ethics]))))
        "every entry is reachable by at least one topic")))
