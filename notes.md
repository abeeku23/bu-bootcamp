# Repository Notes — BU CS Foundations Bootcamp

**Repo:** `bu-bootcamp` (remote: `https://github.com/abeeku23/bu-bootcamp.git`)
**Branch:** `feature/add-module4-notes` (even with `origin/main` — 0 ahead, 0 behind)
**Last updated:** 2026-09-03

---

## Commit History

Five commits, all authored by Nana Thompson on 2026-09-03. One commit per module,
each adding only that module's files — no rewrites of earlier work.

| Commit | Message | Summary |
| --- | --- | --- |
| `adc169e` | Initial commit | 2-line README placeholder |
| `7d3b9ae` | Add bootcamp README with module structure | README expanded to 16 lines describing the bootcamp and module layout |
| `71d98dd` | Add Module 1 activity | Hello World + Greeting programs, plus assignment PDF (4 files, +19 lines) |
| `5832ae1` | Add Module 2 activity | Grade Analyzer with file I/O, sample data, output PDFs (8 files, +158 lines) |
| `320d36b` | Add Module 3 activity | Contact Manager with HashMap and sorting, plus output screenshot (5 files, +72 lines) |

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

- `notes.md` — this file; previously untracked and empty, now filled in.
- No other modified, staged, or deleted files.
- Module 4 work has not been committed yet.

---

## Known Issues / To Do

1. **Compiled artifacts are committed.** `Greeting.class`, `GradeAnalyzer.class`,
   `Contact.class`, and `ContactManager.class` are all tracked in git. Add a
   `.gitignore` containing `*.class` and remove them from the index.
2. **Inconsistent package declarations.**
   - `Greeting.java` → `package bootcamp.Module1;` (capital *M*)
   - `Contact.java` / `ContactManager.java` → `package bootcamp.module3;`
   - `HelloWorld.java` / `GradeAnalyzer.java` → no package at all

   None of these match the actual folder layout (`module1/`, `module2/`,
   `module3/`), so the files only compile when run from the right directory.
   Pick one convention — lowercase, matching the directory structure — and apply
   it consistently.
3. **README is stale.** It lists only modules 1–3 and does not mention Module 4.
4. **Module 4 content is still outstanding** on this branch.
