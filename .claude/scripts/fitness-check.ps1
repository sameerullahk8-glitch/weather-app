# Fitness check for weather-app presentation readiness.
# Scores the project 0-5 on five criteria.
#
# Run from the project root:
#   powershell -File .claude/scripts/fitness-check.ps1

$score = 0
$results = @()

Write-Host ""
Write-Host "Running presentation fitness check..."
Write-Host ""

# --- Criterion 1: tests pass ---
Write-Host "[1/5] Running mvn test..."
mvn test -q *>$null
if ($LASTEXITCODE -eq 0) {
    $score++
    $results += "[1/5] PASS  All tests pass"
} else {
    $results += "[1/5] FAIL  Tests failed  ->  run: mvn test"
}

# --- Criterion 2: quality checks pass ---
Write-Host "[2/5] Running quality checks..."
mvn checkstyle:check pmd:check spotbugs:check -q *>$null
if ($LASTEXITCODE -eq 0) {
    $score++
    $results += "[2/5] PASS  Checkstyle, PMD, and SpotBugs all green"
} else {
    $results += "[2/5] FAIL  Quality violation found  ->  run: mvn checkstyle:check pmd:check spotbugs:check"
}

# --- Criterion 3: README matches current behavior ---
Write-Host "[3/5] Checking README..."
$readme = Get-Content README.md -Raw -ErrorAction SilentlyContinue
if ($readme -match '10\.0' -and $readme -match 'Overcast' -and $readme -match 'Hamburg') {
    $score++
    $results += "[3/5] PASS  README example output matches Berlin's city profile"
} else {
    $results += "[3/5] FAIL  README is out of sync with city profiles"
}

# --- Criterion 4: per-city feature is present in source ---
Write-Host "[4/5] Checking per-city feature in source..."
$svc = Get-Content src/main/java/de/fh/albsig/matrikel/nr/service/MockWeatherService.java -Raw -ErrorAction SilentlyContinue
if ($svc -match 'PROFILES' -and $svc -match '"Berlin"' -and $svc -match '"Hamburg"' -and $svc -match 'getOrDefault') {
    $score++
    $results += "[4/5] PASS  Per-city PROFILES map and fallback present in MockWeatherService"
} else {
    $results += "[4/5] FAIL  Per-city feature missing or incomplete in MockWeatherService"
}

# --- Criterion 5: no target/ files staged ---
Write-Host "[5/5] Checking git staging area..."
$staged = git diff --cached --name-only 2>$null | Where-Object { $_ -match '^target/' }
if (-not $staged) {
    $score++
    $results += "[5/5] PASS  No target/ artifacts staged"
} else {
    $results += "[5/5] FAIL  target/ files are staged  ->  run: git restore --staged target/"
}

# --- Report ---
Write-Host ""
Write-Host "================================"
Write-Host "  PRESENTATION FITNESS SCORE"
Write-Host "================================"
foreach ($r in $results) {
    Write-Host "  $r"
}
Write-Host ""
Write-Host "  Score: $score / 5"
Write-Host ""

if ($score -eq 5) {
    Write-Host "  Ready to present."
} elseif ($score -ge 4) {
    Write-Host "  Almost ready - fix the one failing check above."
} else {
    Write-Host "  Not ready - address failing checks before presenting."
}

Write-Host ""
