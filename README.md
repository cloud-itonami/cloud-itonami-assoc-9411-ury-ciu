# cloud-itonami-assoc-9411-ury-ciu

Industry rule/history catalog for the **Cámara de Industrias del
Uruguay** (CIU) — the TWENTY-SEVENTH entry aligned to **ISIC 9411**
(activities of business, employers, and professional membership
organizations), alongside
[`-9411-sau-fsc`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-sau-fsc)
(Saudi Arabia),
[`-9411-aut-wko`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-aut-wko)
(Austria),
[`-9411-irl-ibec`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-irl-ibec)
(Ireland),
[`-9411-nzl-businessnz`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-nzl-businessnz)
(New Zealand),
[`-9411-cze-spcr`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-cze-spcr)
(Czech Republic),
[`-9411-ind-cii`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-ind-cii)
(India),
[`-9411-zaf-busa`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-zaf-busa)
(South Africa),
[`-9411-bra-cni`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-bra-cni)
(Brazil),
[`-9411-ken-kam`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-ken-kam)
(Kenya),
[`-9411-can-chamber`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-can-chamber)
(Canada),
[`-9411-mex-coparmex`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-mex-coparmex)
(Mexico),
[`-9411-ita-confindustria`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-ita-confindustria)
(Italy),
[`-9411-nld-vnoncw`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-nld-vnoncw)
(Netherlands),
[`-9411-kor-kcci`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-kor-kcci)
(South Korea),
[`-9411-arg-uia`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-arg-uia)
(Argentina),
[`-9411-bel-feb`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-bel-feb)
(Belgium),
[`-9411-dnk-di`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-dnk-di)
(Denmark),
[`-9411-swe-sn`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-swe-sn)
(Sweden),
[`-9411-fin-ek`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-fin-ek)
(Finland),
[`-9411-tha-fti`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-tha-fti)
(Thailand),
[`-9411-chl-sofofa`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-chl-sofofa)
(Chile),
[`-9411-col-andi`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-col-andi)
(Colombia),
[`-9411-cri-uccaep`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-cri-uccaep)
(Costa Rica),
[`-9411-ecu-cip`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-ecu-cip)
(Ecuador),
[`-9411-egy-fei`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-egy-fei)
(Egypt), and
[`-9411-pry-uip`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-pry-uip)
(Paraguay). Part of the
[`cloud-itonami`](https://github.com/cloud-itonami) compliance-fact
family (ADR-2607141700, `cloud-itonami-compliance-fact-federation`,
in `com-junkawasaki/root`).

## Sourcing note

This repo fills Uruguay's previously-open association-axis gap — the
**final entry** in the gap list first identified at tick 141
(originally 22 countries). Uruguay now has real, individually
verified facts across all three axes: country
([`cloud-itonami-iso3166-ury`](https://github.com/cloud-itonami/cloud-itonami-iso3166-ury)),
municipality
([`cloud-itonami-municipality-ury-montevideo`](https://github.com/cloud-itonami/cloud-itonami-municipality-ury-montevideo)),
and association (this repo).

The 12 November 1898 founding date is **doubly corroborated by two
independent sources**: `ciu.com.uy`'s own official page, and the
Uruguayan Parliament's own library catalog
(`pmb.parlamento.gub.uy`), independent of CIU itself. Despite
checking five distinct sources this tick (official site, an older
`historia.html` page which has gone dead, Spanish Wikipedia which
does not exist, and Wikidata which has no entry), only ONE precisely
dateable milestone could be verified — this catalog honestly
contains a single entry rather than forcing a second, weaker one
(matching the precedent set for Ecuador's CIP at tick 159).

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on CIU's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/association/facts.cljc` — the catalog, source of truth.
- `schema/association-rule.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Policy text
itself remains CIU's; this repo stores only citation metadata
(id/title/url/dates), not full text.
