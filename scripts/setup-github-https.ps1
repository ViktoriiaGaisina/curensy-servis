param(
    [Parameter(Mandatory=$true)]
    [string]$Username,

    [Parameter(Mandatory=$false)]
    [string]$RepoName = "curensy-servis",

    [Parameter(Mandatory=$false)]
    [string]$Branch = "main",

    [Parameter(Mandatory=$false)]
    [switch]$RenameMasterToMain
)

# Usage examples:
#   .\scripts\setup-github-https.ps1 -Username your-github-login
#   .\scripts\setup-github-https.ps1 -Username your-github-login -Branch master
#   .\scripts\setup-github-https.ps1 -Username your-github-login -RenameMasterToMain
#
# What it does:
# 1) Sets 'origin' remote to HTTPS (https://github.com/<user>/<repo>.git)
# 2) Enables Git Credential Manager so the first push asks for login + token (PAT) once
# 3) Optionally renames local branch from 'master' to 'main'
# 4) Pushes current branch to origin and sets upstream
#
# NOTE: The script does NOT read or store your token. When Git prompts for authentication, enter:
#   Username: your GitHub username
#   Password: your Personal Access Token (PAT)

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

# Ensure we are in a Git repo
$gitTop = (& git rev-parse --show-toplevel 2>$null)
if (-not $gitTop) {
  Write-Host "This does not look like a Git repository. Run the script from your project root." -ForegroundColor Red
  exit 1
}
Set-Location $gitTop

# Show current remotes
Write-Host "Current remotes:" -ForegroundColor Yellow
& git remote -v

# Configure HTTPS remote
$httpsUrl = "https://github.com/$Username/$RepoName.git"

# If origin does not exist, add; else set-url
$originUrl = (& git remote get-url origin 2>$null)
if (-not $originUrl) {
  Exec "git remote add origin $httpsUrl"
} else {
  Exec "git remote set-url origin $httpsUrl"
}

Write-Host "Origin is now: $httpsUrl" -ForegroundColor Green

# Enable Git Credential Manager (Windows)
Exec "git config --global credential.helper manager"

# Detect current branch
$currentBranch = (& git rev-parse --abbrev-ref HEAD).Trim()
Write-Host "Current branch: $currentBranch" -ForegroundColor Yellow

if ($RenameMasterToMain -and $currentBranch -eq "master") {
  Exec "git branch -M main"
  $currentBranch = "main"
  Write-Host "Renamed branch 'master' -> 'main'" -ForegroundColor Green
}

# If a specific Branch was passed, ensure we are on it
if ($Branch -and $currentBranch -ne $Branch) {
  # Try to switch; if doesn't exist locally, create
  $exists = (& git show-ref --verify --quiet "refs/heads/$Branch"; $?)
  if ($exists) {
    Exec "git switch $Branch"
  } else {
    Exec "git switch -c $Branch"
  }
  $currentBranch = $Branch
}

# First push with upstream
Write-Host "Pushing branch '$currentBranch' to origin (you may be prompted for your GitHub credentials — use PAT as password)." -ForegroundColor Yellow
Exec "git push -u origin $currentBranch"

Write-Host "Done. Future pushes should work without errors." -ForegroundColor Green
