# Repository Notes — BU CS Foundations Bootcamp

**Repo:** `bu-bootcamp` (remote: `https://github.com/abeeku23/bu-bootcamp.git`)
**Branch:** `feature/add-module4-notes` — 2 commits ahead of `origin/main`, 0 behind;
pushed to `origin/feature/add-module4-notes` and in sync with it
**Last updated:** 2026-09-04

---

## Commit History

Commit history snapshot (short SHAs) as of 2026-09-04.
Modules 1–3 each landed in a single self-contained commit — no rewrites of earlier work — followed by housekeeping commits on this branch.

Line counts below are net additions to text files; binary files (`.class`, `.pdf`,
`.png`) contribute to the file count but not the line count.

| Commit | Message | Summary |
| --- | --- | --- |
| `adc169e` | Initial commit | 2-line README placeholder |
| `7d3b9ae` | Add bootcamp README with module structure | README grew from 2 to 14 lines (+14/−2) describing the bootcamp and module layout |
| `71d98dd` | Add Module 1 activity | Hello World + Greeting programs, plus assignment PDF (4 files, +19 lines) |
| `5832ae1` | Add Module 2 activity | Grade Analyzer with file I/O, sample data, output PDFs (8 files, +158 lines) |
| `320d36b` | Add Module 3 activity | Contact Manager with HashMap and sorting, plus output screenshot (5 files, +72 lines) |
| `a8b3355` | Add Module 4 notes on Git and GitHub workflow | Created this `notes.md` (1 file, +84 lines) |
| `ed80e84` | fix: remove .class files | Added `.gitignore` (+22 lines) and untracked the four committed `.class` files |

---

## Module Breakdown

### Module 1 — Development environment and first Java programs
- **`HelloWorld.java`** — minimal `main` method printing a single line. Verifies the
  JDK install and compile/run workflow.
- **`Greeting.java`** — uses `Scanner` to read two inputs from `System.in` (name and
  occupation), concatenates them into a formatted greeting, and closes the scanner.
- **`Module1_Assignment_NT.pdf`** — submitted assignment write-up.

### Module 2 — Programming fundamentals (variables, control flow, methods, files)
- **`GradeAnalyzer.java`** (126 lines) — the largest program in the repo. Demonstrates:
  - **File input:** reads `scores.txt` with `BufferedReader` inside try-with-resources.
  - **Input validation:** trims each line, skips blanks, and catches
    `NumberFormatException` for non-numeric rows; counts skipped lines in a
    static `invalidLinesSkipped` field.
  - **Computation:** single-pass high/low tracking with `Integer.MIN_VALUE` /
    `Integer.MAX_VALUE` sentinels, plus an average and an A–F grade distribution.
  - **File output:** writes a formatted `report.txt`.
  - **Guard clause:** exits early with a message if no valid scores were found.
- **Data / evidence files:** `scores.txt`, `numbers.txt`, generated `report.txt`
  (11 scores processed, 2 invalid lines skipped, avg 77.55), and terminal/output PDFs.

### Module 3 — Data structures and object-oriented basics
- **`Contact.java`** — a small encapsulated model class: private `name` and `phone`
  fields, a constructor, getters, and an overridden `toString()` returning
  `name | phone`.
- **`ContactManager.java`** — driver class demonstrating:
  - **`HashMap<String, Contact>`** keyed by contact name, populated with four entries.
  - **`lookUp(...)`** — retrieves by key and handles the miss case (`null` check)
    rather than letting it fail.
  - **`printSorted(...)`** — copies `keySet()` into an `ArrayList`, sorts with
    `Collections.sort`, and prints in alphabetical order (working around the fact
    that a `HashMap` has no guaranteed iteration order).
- **`contactmanager-output.png`** — screenshot of the program's console output.

---

## Current Working-Tree State

- Working tree is clean — nothing modified, staged, or untracked.
- `notes.md` (this file) was committed in `a8b3355`.
- `.gitignore` was committed in `ed80e84`; no compiled artifacts remain tracked.
- There is no `module4/` directory; this file is the Module 4 deliverable so far.

---

## Known Issues / To Do

1. ~~**Compiled artifacts are committed.**~~ **Resolved in `ed80e84`.** A `.gitignore`
   covering `*.class`, archives, and build directories was added, and the four
   tracked `.class` files were removed from the index (they remain on disk).
   Note: they are still present in the history of `71d98dd`, `5832ae1`, and
   `320d36b`; purging that would require a history rewrite, which is not planned.
2. **Inconsistent package declarations.**
   - `Greeting.java` → `package bootcamp.Module1;` (capital *M*)
   - `Contact.java` / `ContactManager.java` → `package bootcamp.module3;`
   - `HelloWorld.java` / `GradeAnalyzer.java` → no package at all

   None of these match the actual folder layout (`module1/`, `module2/`,
   `module3/`), so the files only compile when run from the right directory.
   Pick one convention — lowercase, matching the directory structure — and apply
   it consistently.
3. **README is stale.** It lists only modules 1–3 and does not mention Module 4.
4. **Module 4 activity files are still outstanding.** The written notes are
   committed, but no `module4/` source directory exists yet.
