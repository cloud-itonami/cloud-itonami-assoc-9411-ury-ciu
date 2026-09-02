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

The 12 November 1898 founding rests on three documents, one of which is not
CIU's: CIU's own institutional page, article 1 of CIU's own Estatutos, and
the catalogue of the library of Uruguay's Poder Legislativo
(`pmb.parlamento.gub.uy`), which is independent of CIU.

**What changed on 2026-09-02.** This catalog held one entry, and said so
honestly: five sources had been checked on 2026-07-18 and only one precisely
dateable milestone came back. That note was true about what had been checked
and wrong about where the ceiling was. CIU publishes its own **Estatutos**
and its own **Código de Ética** as PDFs from `ciu.com.uy`, and both answer
200. Those are the association's own governance rules, which is what an
association-rule catalog is for. The catalog now holds **31 entries read
article by article** from five primary sources, and the Poder Legislativo
record — named in the old prose but never actually cited as a URL — is now
an entry.

The older `historia.html` page is still dead, there is still no Wikidata
entry and no Spanish Wikipedia article. None of that turned out to bound
what could be sourced.

## Provenance is checkable, not asserted

Every entry carries the article it comes from and the **verbatim span** it
rests on:

```bash
nbb scripts/verify-catalog.cljs          # structural only (offline)
nbb scripts/verify-catalog.cljs --live   # fetch every :url, require every quote
```

Exit is three-valued: `0` checked and clean, `1` findings printed, `2`
**REFUSED** — could not check. "I could not read the catalog" and "I read the
catalog and it was fine" must not leave the same trace.

Reachability alone would not do. A URL that returns 200 without the claim
looks exactly like one that supports it, which is how a citation rots without
anyone noticing. `--live` asks whether the document still says the thing the
entry says it says.

Measured 2026-09-02: `FETCHED 5/5`, 31 entries, 31 citations, `ok`. The check
was also shown to fail for the reasons it names — a single altered quote
reports `quote-not-in-source` on that entry and no other; an empty catalog
REFUSES with exit 2 rather than passing vacuously; and disabling the HTML
entity decoder makes the Poder Legislativo quote unfindable, because that
page writes `C&aacute;mara`. That last one is why the decoder exists: an
incomplete decoder does not weaken this check, it **inverts** it — a source
that is serving the claim reports as if the citation were fabricated.

## On dates, and why some entries carry none

CIU's Estatutos state **no approval date anywhere in their own text**. The
only date the instrument gives is the Cámara's own constitution, 12 November
1898, in article 1. The PDF's file metadata carries a July 2014 creation date
and the filename CIU publishes is `estatutos_ciu_07.14.pdf` — but neither is
the instrument saying when it was adopted, and a date lifted from file
metadata would sit in the same field, looking the same, as one the document
actually states.

So those entries carry `:association-rule/date-unknown-because` instead, and
the verifier requires it: an entry with neither a date nor a reason is a
finding, and so is an entry carrying both. An absence that was forgotten and
an absence that was recorded must not read alike.

The Código de Ética *does* state its approval date in its own first line
(28 November 2007), so its entries carry it.

## Sources

| Source | What it is | Entries |
|---|---|---|
| [`estatutos_ciu_07.14.pdf`](https://www.ciu.com.uy/wp-content/uploads/2022/04/estatutos_ciu_07.14.pdf) | CIU's own constitutive instrument | 24 |
| [`codigo_de_etica…pdf`](https://www.ciu.com.uy/wp-content/uploads/2022/04/codigo_de_etica_de_la_camara_de_industrias_del_uruguay.pdf) | CIU's own Código de Ética, approved 2007-11-28 | 4 |
| [`que-es-la-ciu`](https://www.ciu.com.uy/propuesta-de-valor/que-es-la-ciu/) | CIU's institutional page | 1 |
| [`consejo-directivo`](https://www.ciu.com.uy/nosotros/consejo-directivo/) | CIU's own board page | 1 |
| [`pmb.parlamento.gub.uy`](https://pmb.parlamento.gub.uy/pmb/opac_css/index.php?lvl=notice_display&id=33243) | Poder Legislativo library catalogue — **not CIU** | 1 |

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on CIU's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `data/datascript-tx.edn` — the **authored** copy, the source of truth.
- `src/association/facts.cljc` — the catalog, held to the data file field by
  field by `test/association/facts_test.clj`.
- `src/association_facts.kotoba` — the Kotoba port, **generated**. It reaches
  the Kotoba oracle, wasm and both native ISAs, which the `.cljc` cannot.
  Do not hand-edit:

  ```bash
  nbb scripts/gen-kotoba-port.cljs           # rewrite the port
  nbb scripts/gen-kotoba-port.cljs --check   # exit 1 if someone hand-edited it
  ```

- `schema/association-rule.edn` — DataScript schema. Query this alongside
  other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`.

`clojure -M:test` runs both suites: the catalog against the authored data
file, and the Kotoba port against the catalog field by field, for all four
targets the module claims.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Policy text
itself remains CIU's; this repo stores only citation metadata
(id/title/url/dates), not full text.
