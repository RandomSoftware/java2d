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

## Formatting

Always format code before committing it

```bash
./gradlew ktfmtFormat # format code 
```

## Commit message convention

Commit messages follow [Conventional Commits rules](https://www.conventionalcommits.org/en/v1.0.0/)