param(
    [Parameter(Mandatory=$true)]
    [string]$Username,

    [Parameter(Mandatory=$false)]
    [string]$RepoName = "curensy-servis",

    [Parameter(Mandatory=$false)]
    [switch]$RenameToMain
)

# Purpose:
# - Verifies that the current git repo points to https://github.com/<user>/<repo>.git
# - Shows current branch and remote branches
# - If requested ( -RenameToMain ), renames current branch to 'main'
# - Pushes the current branch and sets upstream
# - Prints next steps to either:
#     a) Use 'main' everywhere, or
#     b) Keep your branch name (e.g., master) and change GitHub default branch via UI

function Exec {
  param([string]$cmd)
  Write-Host "[RUN] $cmd" -ForegroundColor Cyan
  $out = & powershell -NoProfile -Command $cmd 2>&1
  if ($LASTEXITCODE -ne 0) {
    Write-Host "[ERROR] Command failed with exit code $LASTEXITCODE" -ForegroundColor Red
    Write-Host $out
    exit $LASTEXITCODE
  }
  if ($out) { Write-Host $out }
}

# Ensure we are inside a git repo
$gitTop = (& git rev-parse --show-toplevel 2>$null)
if (-not $gitTop) {
  Write-Host "This does not look like a Git repository. Run the script from your project root." -ForegroundColor Red
  exit 1
}
Set-Location $gitTop

Write-Host "Current remotes:" -ForegroundColor Yellow
& git remote -v

$expected = "https://github.com/$Username/$RepoName.git"

# If origin missing, add it
$originUrl = (& git remote get-url origin 2>$null)
if (-not $originUrl) {
  Exec "git remote add origin $expected"
  $originUrl = $expected
} else {
  # If origin is SSH or points somewhere else, switch to expected HTTPS
  if ($originUrl -ne $expected) {
    Write-Host "Updating origin from '$originUrl' to '$expected'" -ForegroundColor Yellow
    Exec "git remote set-url origin $expected"
    $originUrl = $expected
  }
}
Write-Host "Origin: $originUrl" -ForegroundColor Green

# Enable Git Credential Manager (Windows)
Exec "git config --global credential.helper manager"

# Show current branch
$current = (& git rev-parse --abbrev-ref HEAD).Trim()
Write-Host "Local current branch: $current" -ForegroundColor Yellow

# Optionally rename to main
if ($RenameToMain -and $current -ne 'main') {
  Exec "git branch -M main"
  $current = 'main'
  Write-Host "Renamed current branch to 'main'" -ForegroundColor Green
}

# Ensure there is at least one commit to push
$commitCount = (& git rev-list --count HEAD).Trim()
if (-not $commitCount -or [int]$commitCount -lt 1) {
  Write-Host "No commits found. Making an initial commit with current files..." -ForegroundColor Yellow
  Exec "git add -A"
  Exec "git commit -m 'Initial commit'"
}

# Push current branch
Write-Host "Pushing '$current' to origin (you may be prompted for GitHub login + PAT)..." -ForegroundColor Yellow
Exec "git push -u origin $current"

# List remote branches
Write-Host "Remote branches now are:" -ForegroundColor Yellow
& git ls-remote --heads origin | ForEach-Object { $_ }

if ($current -eq 'main') {
  Write-Host "Done. Your repository page should no longer show 'Quick setup'. Refresh the GitHub page." -ForegroundColor Green
} else {
  Write-Host "Done. You pushed branch '$current'." -ForegroundColor Green
  Write-Host "If the GitHub page still looks empty, either:" -ForegroundColor Yellow
  Write-Host "  1) Open Settings -> Branches in your repo on GitHub and change Default branch to '$current'" -ForegroundColor Yellow
  Write-Host "  2) Or run this script again with -RenameToMain to switch to 'main' and push it (recommended)" -ForegroundColor Yellow
}
