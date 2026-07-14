# Hook: blocks git commits that would stage target/ build artifacts.
# Claude Code calls this before every Bash tool use.
# The tool input arrives as JSON on stdin.

$raw = [Console]::In.ReadToEnd()
if (-not $raw.Trim()) { exit 0 }

try {
    $toolInput = $raw | ConvertFrom-Json
    $cmd = [string]$toolInput.command
} catch {
    exit 0
}

# Only act on git commit commands.
if ($cmd -notmatch 'git\s+commit') {
    exit 0
}

$staged = git diff --cached --name-only | Where-Object { $_ -match '^target/' }
if ($staged) {
    $list = ($staged | ForEach-Object { "  $_" }) -join "`n"
    Write-Host ""
    Write-Host "[HOOK] Blocked: target/ build artifacts are staged for commit."
    Write-Host $list
    Write-Host ""
    Write-Host "Fix: git restore --staged target/"
    Write-Host ""
    exit 2
}

exit 0
