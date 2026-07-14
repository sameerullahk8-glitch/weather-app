# presentation-check

Inspect the weather-app repository and produce summary 
Work through the steps below in order. Do not skip any step.

## Step 1 — Verify the per-city feature

Read `src/main/java/de/fh/albsig/matrikel/nr/service/MockWeatherService.java`.

Check for:
- A `private static final Map<String, WeatherReport> PROFILES` field
- Entries for Berlin, Hamburg, München, Munich, and Stuttgart with distinct values
- A `getOrDefault` call that returns a fallback for unknown cities
- Blank-city validation that throws `WeatherException`

Report each item as PRESENT or MISSING.

## Step 2 — Verify the tests

Read `src/test/java/de/fh/albsig/matrikel/nr/service/MockWeatherServiceTest.java`.

Count the total number of `@Test` methods.
Identify which tests specifically exercise the per-city profiles (look for city names other than a generic "Berlin" city-name check).

Report:
- Total test count
- Which tests prove the per-city feature works
- Whether the fallback and alias cases are covered

## Step 3 — Verify the README

Read `README.md`.

Check:
- The example XML output shows Berlin with temperature `10.0` and condition `Overcast`
- The description paragraph mentions known cities (Hamburg, Stuttgart) and the fallback

Report: IN SYNC or OUT OF SYNC, with one sentence explaining why.

## Step 4 — Produce the final report

Output three clearly labelled sections:

**Feature status**
One sentence: what the per-city map does and whether every required part is intact.

**Test coverage**
One sentence: total test count and which specific tests demonstrate the feature to a professor.

**Professor pitch**
Exactly three sentences you can say out loud during the presentation without reading from a screen.
Make them confident, concrete, and jargon-light.
