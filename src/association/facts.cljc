(ns association.facts
  "Industry rule/history catalog for the Camara de Industrias del Uruguay
  (CIU) -- an industry-association-level source per ADR-2607141700
  (cloud-itonami-compliance-fact-federation), aligned to ISIC 9411
  (activities of business, employers, and professional membership
  organizations). Uruguay has real, individually verified facts across all
  three axes: country (cloud-itonami-iso3166-ury), municipality
  (cloud-itonami-municipality-ury-montevideo), and association (this entry).

  SOURCING, and how it changed. On 2026-07-18 this catalog held a single
  entry. Five sources were checked that day and only one precisely dateable
  milestone came back -- the 12 November 1898 founding -- so rather than
  force a second, weaker fact the catalog said so and stopped at one.

  On 2026-09-02 the sourcing was re-measured and the ceiling was not where
  the note said it was. CIU publishes its own Estatutos and its own Codigo
  de Etica as PDFs from ciu.com.uy, and both answer 200. Those are the
  association's own governance rules, which is what an association-rule
  catalog is for; the entries below are read directly from them, article by
  article, plus the founding fact from CIU's institutional page and its
  independent corroboration in the catalogue of the library of Uruguay's
  Poder Legislativo -- which had been named in the old prose but never
  actually cited as a URL. The older `historia.html` page is still dead,
  there is still no Wikidata entry and no Spanish Wikipedia article; none of
  that turned out to bound what could be sourced.

  Provenance is checkable, not asserted. Every entry carries the article it
  comes from and the verbatim span it rests on, and
  `nbb scripts/verify-catalog.cljs --live` fetches each :url and fails if the
  document no longer contains that span. Reachability alone would not do:
  a URL that returns 200 without the claim is indistinguishable from one that
  supports it, which is exactly how a citation rots without anyone noticing.

  ON DATES, and why some entries carry none. CIU's Estatutos state no
  approval date anywhere in their own text -- the only date the instrument
  gives is the Camara's own constitution, 12 November 1898, in article 1.
  The PDF's file metadata carries a July 2014 creation date and the filename
  CIU publishes is `estatutos_ciu_07.14.pdf`, but neither is the instrument
  saying when it was adopted, and a date lifted from file metadata would sit
  in the same field, looking the same, as one the document actually states.
  So those entries carry `:date-unknown-because` instead, and the verifier
  requires it: an entry that simply forgot its date and one that recorded
  why it has none must not read alike. The Codigo de Etica does state its
  approval date in its own first line, so its entries carry it.

  `data/datascript-tx.edn` is the authored copy. This catalog and
  `src/association_facts.kotoba` are both readings of it, and both are held
  to it -- this one by test/association/facts_test.clj, the Kotoba port by
  `nbb scripts/gen-kotoba-port.cljs --check`.

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"ciu"
   [{:association-rule/id "ciu.founding-1898-11-12"
     :association-rule/title "Camara de Industrias del Uruguay (CIU) was constituted on 12 November 1898, as CIU states on its own institutional page"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/propuesta-de-valor/que-es-la-ciu/"
     :association-rule/url-provenance :official-ciu-com-uy
     :association-rule/source-article "que-es-la-ciu"
     :association-rule/source-quote "Nuestra constitución se remonta al 12 de noviembre de 1898"
     :association-rule/established-date "1898-11-12"
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.founding-corroborated-parlamento"
     :association-rule/title "The 12 November 1898 founding is corroborated independently of CIU by the catalogue of the library of Uruguay's Poder Legislativo"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://pmb.parlamento.gub.uy/pmb/opac_css/index.php?lvl=notice_display&id=33243"
     :association-rule/url-provenance :parlamento-gub-uy-library-catalogue
     :association-rule/source-article "catalogue-record-33243"
     :association-rule/source-quote "Cámara de Industrias del Uruguay : fundada el 12 de noviembre de 1898"
     :association-rule/established-date "1898-11-12"
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.constitution-art-1"
     :association-rule/title "CIU's own constitutive instrument repeats the 12 November 1898 date and subjects the Camara to this Estatuto and to the applicable laws (Estatutos article 1)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "1"
     :association-rule/source-quote "La Cámara de Industrias del Uruguay, constituída el 12 de noviembre de 1898, se regirá en adelante por el presente Estatuto social y por las demás leyes aplicables."
     :association-rule/established-date "1898-11-12"
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.domicile-art-2"
     :association-rule/title "CIU's seat is Montevideo, without prejudice to offices elsewhere in Uruguay or abroad (Estatutos article 2)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "2"
     :association-rule/source-quote "Se fija su domicilio en la ciudad de Montevideo"
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.duration-art-3"
     :association-rule/title "CIU endures indefinitely unless its dissolution and liquidation are agreed under the Estatuto (Estatutos article 3)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "3"
     :association-rule/source-quote "Esta Cámara durará indefinidamente, en tanto no se acuerde su disolución y liquidación de conformidad con el presente Estatuto."
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.political-neutrality-art-6"
     :association-rule/title "CIU is barred from any religious or philosophical pronouncement and from any partisan political pronouncement, while remaining free to opine on questions touching industry (Estatutos article 6)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "6"
     :association-rule/source-quote "Le está vedado a la Cámara todo pronunciamiento en asuntos de carácter religioso o filosófico"
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.member-categories-art-7"
     :association-rule/title "CIU membership falls into four categories -- activos, suscriptores, protectores and honorarios (Estatutos article 7)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "7"
     :association-rule/source-quote "Los socios de la Cámara de Industrias del Uruguay se dividen en cuatro categorías"
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:membership}}
    {:association-rule/id "ciu.subscriber-threshold-art-7"
     :association-rule/title "A socio suscriptor may occupy no more than four people and have annual sales excluding VAT no greater than two million unidades indexadas; the category carries no vote and no eligibility, and may not be held beyond four years (Estatutos article 7)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "7"
     :association-rule/source-quote "ocupar no más de cuatro (4) personas y cuyas ventas anuales excluido el IVA, no superen el equivalente a dos millones (2.000.000) de unidades indexadas (UI)"
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:membership}}
    {:association-rule/id "ciu.admission-veto-art-8"
     :association-rule/title "An application for membership is rejected if a secret ballot of the Consejo Directivo returns three votes against (Estatutos article 8)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "8"
     :association-rule/source-quote "la que será rechazada sí, en votación secreta, reúne tres votos en contra"
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:membership}}
    {:association-rule/id "ciu.voting-seniority-art-9"
     :association-rule/title "An active member of one year or more standing may vote in, and stand for, the elections that compose the Consejo Directivo and the Comision Fiscal (Estatutos article 9)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "9"
     :association-rule/source-quote "Cuando tengan un año o más de antigüedad como socios activos, ejercer el voto activo y ser electos en las elecciones para la integración del Consejo Directivo y Comisión Fiscal."
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:membership :governance}}
    {:association-rule/id "ciu.suspension-arrears-art-12"
     :association-rule/title "Three consecutive months of unpaid dues suspends a member automatically, and six months without settling them forfeits membership (Estatutos article 12)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "12"
     :association-rule/source-quote "Por la falta de pago de la cuota social durante tres meses consecutivos"
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:membership}}
    {:association-rule/id "ciu.assembly-supreme-art-19"
     :association-rule/title "The Asamblea General is CIU's supreme organ (Estatutos article 19)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "19"
     :association-rule/source-quote "La Asamblea General es el órgano supremo de la Cámara."
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.ordinary-assembly-art-20"
     :association-rule/title "The Asamblea General meets in ordinary session once a year, within 150 days of the close of the financial year (Estatutos article 20)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "20"
     :association-rule/source-quote "Se reunirá en sesión ordinaria una vez al año, dentro de los 150 días siguientes a la clausura del ejercicio económico"
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.assembly-quorum-art-21"
     :association-rule/title "An assembly sits on first call with 10% of active members present and on second call with whoever attends (Estatutos article 21)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "21"
     :association-rule/source-quote "En primera convocatoria, la Asamblea podrá sesionar desde que esté presente el 10% de los socios activos, y en segunda convocatoria con el número de socios que concurra."
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.council-size-art-25"
     :association-rule/title "The Consejo Directivo is composed of sixteen full members (Estatutos article 25)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "25"
     :association-rule/source-quote "El Consejo Directivo está integrado por dieciséis miembros titulares"
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.council-term-art-25"
     :association-rule/title "Consejo Directivo terms run four years and the body renews by halves every two years (Estatutos article 25)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "25"
     :association-rule/source-quote "será de cuatro años, renovándose por mitades cada dos años"
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.council-conflict-art-26"
     :association-rule/title "Two members of the same associated firm, or of the same economic group, may not sit on the Consejo Directivo at the same time (Estatutos article 26)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "26"
     :association-rule/source-quote "No podrán formar parte del Consejo Directivo simultáneamente dos miembros que integren una misma firma asociada, o que pertenezcan al mismo grupo económico"
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.council-attendance-art-30"
     :association-rule/title "A member of the Consejo may be declared to have vacated the seat after missing more than three consecutive ordinary sessions without just cause (Estatutos article 30)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "30"
     :association-rule/source-quote "dejare de asistir a más de tres sesiones ordinarias consecutivas"
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.fiscal-year-art-31"
     :association-rule/title "CIU's financial year closes on 30 November each year (Estatutos article 31)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "31"
     :association-rule/source-quote "El ejercicio económico de la Institución se cerrará el 30 de noviembre de cada año."
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:finance}}
    {:association-rule/id "ciu.real-property-art-31"
     :association-rule/title "Buying, selling or mortgaging real property is the one power of administration the Consejo Directivo cannot exercise alone -- it requires a resolution of the Asamblea General (Estatutos article 31)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "31"
     :association-rule/source-quote "para comprar, vender o hipotecar bienes inmuebles se necesitará resolución de la Asamblea General"
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:finance :governance}}
    {:association-rule/id "ciu.president-annual-art-34"
     :association-rule/title "The President is elected annually by the Consejo Directivo, by secret ballot, from among its own members (Estatutos article 34)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "34"
     :association-rule/source-quote "El Presidente se elegirá anualmente por el Consejo"
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.fiscal-commission-art-44"
     :association-rule/title "The Comision Fiscal is three full members and three alternates, all active members, elected with the Consejo, serving two years and re-electable once (Estatutos article 44)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "44"
     :association-rule/source-quote "La Comisión Fiscal estará integrada por tres miembros titulares y tres suplentes respectivos"
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:finance :governance}}
    {:association-rule/id "ciu.electoral-commission-art-46"
     :association-rule/title "The Comision Electoral is three full members, active members of the Camara, chosen by the ordinary Asamblea General in election years on the Consejo's proposal (Estatutos article 46)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "46"
     :association-rule/source-quote "La Comisión Electoral estará integrada por tres miembros titulares, socios activos de la Cámara."
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.amendment-threshold-art-48"
     :association-rule/title "Amending the Estatuto requires at least 10% of active members present and the concurring vote of two thirds of the active members present (Estatutos article 48)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "48"
     :association-rule/source-quote "Para aprobar una enmienda al Estatuto se requerirá la presencia de al menos el 10% de los socios activos y el voto conforme de los 2/3 de los socios activos presentes."
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.dissolution-threshold-art-49"
     :association-rule/title "Dissolution may be agreed only by an extraordinary Asamblea General convened for that sole purpose, and requires the votes of 75% of active members (Estatutos article 49)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "49"
     :association-rule/source-quote "Para ello serán precisos los votos del 75% de los socios activos."
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ciu.dissolution-assets-art-49"
     :association-rule/title "On liquidation the remaining assets go to non-profit social welfare or industrial education institutions with legal personality (Estatutos article 49)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-estatutos
     :association-rule/source-article "49"
     :association-rule/source-quote "deberán ser adjudicados a una o varias instituciones de beneficencia social o de enseñanza industrial"
     :association-rule/date-unknown-because :estatutos-text-states-no-approval-date
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:finance :governance}}
    {:association-rule/id "ciu.code-of-ethics-2007-11-28"
     :association-rule/title "CIU's Codigo de Etica was approved by the Consejo Directivo at its session of Wednesday 28 November 2007, and states that date in its own first line"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/codigo_de_etica_de_la_camara_de_industrias_del_uruguay.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-codigo-etica
     :association-rule/source-article "preamble"
     :association-rule/source-quote "Aprobado por el Consejo Directivo en la sesión del día miércoles 28 de noviembre de 2007"
     :association-rule/established-date "2007-11-28"
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:ethics}}
    {:association-rule/id "ciu.code-of-ethics-scope-s3"
     :association-rule/title "The Codigo de Etica binds the industrial companies that are members of CIU (Codigo de Etica article 3)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/codigo_de_etica_de_la_camara_de_industrias_del_uruguay.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-codigo-etica
     :association-rule/source-article "3"
     :association-rule/source-quote "Este Código se aplica y deberá ser respetado por las empresas industriales socias de la Cámara de Industrias del Uruguay."
     :association-rule/established-date "2007-11-28"
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:ethics :membership}}
    {:association-rule/id "ciu.code-of-ethics-mediation-s9"
     :association-rule/title "Before bringing an action against a fellow industrialist over commercial conduct, a member must first notify its gremial and CIU so that they may consider mediating (Codigo de Etica article 9)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/codigo_de_etica_de_la_camara_de_industrias_del_uruguay.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-codigo-etica
     :association-rule/source-article "9"
     :association-rule/source-quote "comunicarlo previamente a su Gremial y a la Cámara de Industrias del Uruguay, por si éstas considerasen oportuno realizar una tarea de mediación."
     :association-rule/established-date "2007-11-28"
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:ethics}}
    {:association-rule/id "ciu.code-of-ethics-sanctions-s10"
     :association-rule/title "Sanctions for breaches of the Codigo de Etica are dictated by CIU's Consejo Directivo or by whomever it delegates (Codigo de Etica article 10)"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/wp-content/uploads/2022/04/codigo_de_etica_de_la_camara_de_industrias_del_uruguay.pdf"
     :association-rule/url-provenance :official-ciu-com-uy-codigo-etica
     :association-rule/source-article "10"
     :association-rule/source-quote "dispondrá las sanciones que correspondan, a dictarse por su Consejo Directivo, o en quien éste delegue sus atribuciones."
     :association-rule/established-date "2007-11-28"
     :association-rule/retrieved-at "2026-09-02"
     :association-rule/topic #{:ethics :membership}}
    {:association-rule/id "ciu.council-renewal-published"
     :association-rule/title "CIU publishes on its own Consejo Directivo page that the body is drawn from industrialists across sectors and renews every two years, which is what Estatutos article 25 provides"
     :association-rule/association "ciu"
     :association-rule/isic "9411"
     :association-rule/country "URY"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ciu.com.uy/nosotros/consejo-directivo/"
     :association-rule/url-provenance :official-ciu-com-uy
     :association-rule/source-article "consejo-directivo"
     :association-rule/source-quote "El Consejo Directivo se integra por empresarios de diferentes rubros industriales y se renueva cada dos años"
     :association-rule/date-unknown-because :page-states-no-date
     :association-rule/retrieved-at "2026-09-02"
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
                 (count (get catalog "ciu")) " CIU entries, each citing a "
                 "primary source with the article and the verbatim span it "
                 "rests on. Extend `association.facts/catalog`, never "
                 "fabricate an id/url.")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))
