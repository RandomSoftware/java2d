# CLAUDE.md

## Project Overview

A Java2D cellular automaton visualizer written in Kotlin. It simulates 1D cellular automata (Wolfram-style) and renders each generation as a row of pixels, building up a 2D image over time.

## Build & Run

```bash
./gradlew test       # run tests
./gradlew run        # launch the application
```

- Kotlin 1.6.0, JUnit 4.13.2
- Main class: `ru.randomsoftware.java2d.ApplicationKt`

## Architecture

Three-layer architecture: **generators → automata → simulation → renderers**

### Rules (`rules/`)
- `Rule<T>` — interface: `calculate(a: T, b: T, c: T): T`
- `NumericRule(base: Int)` — Wolfram-style rule encoded as an integer (0–255). Each bit determines the output for one of the 8 possible `(a, b, c)` combinations. Throws `IllegalArgumentException` for values outside `[0, 255]`.
- `EqualityRule` — always returns `b` (the center cell), ignoring neighbors.

### Generators (`generators/`)
- `LineGenerator<T>` — interface: `generate(size: Int): List<T>`
- `MiddlePointLineGenerator` — produces a Boolean row with only the middle cell set to `true`.
- `RandomLineGenerator` — produces a random Boolean row.

### Automata (`automata/`)
- `Automata<T>` — interface: `buildGenerations(n: Int): List<List<T>>`
- `LineCellularAutomata<T>` — wraps a generator + rule; builds generations using a toroidal (wrap-around) neighborhood.

### Simulation (`simulation/`)
- `StaticSimulation<T>` — runs the automata for `Application.HEIGHT` generations and hands the matrix to a renderer.

### Renderers (`renderers/`)
- `Renderer<T>` — interface: `render(matrix: List<List<T>>)`
- `RendererBW` — renders Boolean matrix as black/white pixels in a Swing frame.
- `RendererRGB` — renders a three-channel (RGB) matrix.

## Tests

Tests live in `src/test/kotlin/ru/randomsoftware/java2d/rules/`.

- `NumericRuleTest` — covers constructor validation, `intToBooleanList`, and all 8 `calculate` input combinations using rule 110 as the reference case; also exhaustively tests rules 0 and 255.
- `EqualityRuleTest` — covers all 8 input combinations grouped by the value of `b`.