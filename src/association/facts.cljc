(ns association.facts
  "Industry rule/history catalog for the Cámara de Industrias del
  Uruguay (CIU) -- a 69th industry-association-level source (see
  cloud-itonami-assoc-9411-sau-fsc, -9411-aut-wko, -9411-irl-ibec,
  -9411-nzl-businessnz, -9411-cze-spcr, -9411-ind-cii, -9411-zaf-busa,
  -9411-bra-cni, -9411-ken-kam, -9411-can-chamber, -9411-mex-coparmex,
  -9411-ita-confindustria, -9411-nld-vnoncw, -9411-kor-kcci,
  -9411-arg-uia, -9411-bel-feb, -9411-dnk-di, -9411-swe-sn, -9411-fin-ek,
  -9411-tha-fti, -9411-chl-sofofa, -9411-col-andi, -9411-cri-uccaep,
  -9411-ecu-cip, -9411-egy-fei, -9411-pry-uip for the first
  twenty-six) per ADR-2607141700 (cloud-itonami-compliance-fact-
  federation). The TWENTY-SEVENTH entry aligned to ISIC 9411
  (activities of business, employers, and professional membership
  organizations). Fills Uruguay's previously-open association-axis
  gap -- the FINAL entry in the gap list first identified at tick
  141 (originally 22 countries) -- Uruguay now has real, individually
  verified facts across ALL THREE axes (country:
  cloud-itonami-iso3166-ury statute.facts; municipality:
  cloud-itonami-municipality-ury-montevideo; association: this
  entry).

  The 12 November 1898 founding date is doubly corroborated by two
  INDEPENDENT sources: ciu.com.uy's own official 'Qué es la CIU?'
  page, directly read, states verbatim 'Nuestra constitución se
  remonta al 12 de noviembre de 1898 con el objetivo de promover el
  desarrollo industrial del país'; and the Uruguayan Parliament's own
  library catalog (pmb.parlamento.gub.uy), independent of CIU itself,
  directly read, states verbatim 'Cámara de Industrias del Uruguay :
  fundada el 12 de noviembre de 1898'. No Wikidata entry exists for
  CIU at all (search returned 'no results matching the query'), no
  Spanish Wikipedia article exists (404), and CIU's own older
  'historia.html' page (referenced in search results) has gone dead
  (404) -- despite checking five distinct sources this tick, only
  ONE precisely dateable milestone could be found; rather than force
  a second, weaker fact, this catalog honestly contains a single,
  doubly-corroborated entry (matching the precedent set for Ecuador's
  CIP at tick 159, which also used a single primary fact when a
  second could not be verifiably sourced).

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"ciu"
   [{:association-rule/id "ciu.founding-1898-11-12"
     :association-rule/title "Cámara de Industrias del Uruguay (CIU) founded 12 November 1898 (ciu.com.uy's own official page, independently corroborated by the Uruguayan Parliament's own library catalog pmb.parlamento.gub.uy)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/propuesta-de-valor/que-es-la-ciu/"
     :association-rule/url-provenance :official-ciu-com-uy
     :association-rule/established-date "1898-11-12"
     :association-rule/retrieved-at "2026-07-18"
     :association-rule/topic #{:governance}}]})

(defn spec-basis [association] (get catalog association))

(defn coverage
  ([] (coverage (keys catalog)))
  ([associations]
   (let [have (filter catalog associations)
         missing (remove catalog associations)]
     {:requested (count associations)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-9411-ury-ciu Wave 0 (ADR-2607141700): "
                 (count (get catalog "ciu")) " CIU entry seeded "
                 "with ciu.com.uy official + Uruguayan Parliament library catalog corroboration "
                 "(no Wikidata entry, no Wikipedia article, and the older historia.html page has "
                 "gone dead -- only one precisely dateable fact could be verified). "
                 "Extend `association.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))
