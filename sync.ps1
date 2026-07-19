param(
    [string]$CommitMessage = "Update TCS PRA practice sets"
)

# 1. Detect javac.exe
$javacPath = "javac"
$pathsToTest = @(
    "C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.3.5\jbr\bin\javac.exe",
    "C:\Program Files\Java\jdk*\bin\javac.exe"
)
$compilerFound = $false

# Test default path javac
try {
    $null = Get-Command javac -ErrorAction Stop
    $javacPath = "javac"
    $compilerFound = $true
} catch {
    # Scan known paths
    foreach ($p in $pathsToTest) {
        $resolved = Resolve-Path $p -ErrorAction SilentlyContinue
        if ($resolved) {
            if ($resolved -is [array]) {
                $javacPath = $resolved[0].Path
            } else {
                $javacPath = $resolved.Path
            }
            $compilerFound = $true
            break
        }
    }
}

if (-not $compilerFound) {
    Write-Host "Warning: Could not auto-detect 'javac' path. Compilation checks will be skipped." -ForegroundColor Yellow
} else {
    Write-Host "Using Java Compiler: $javacPath" -ForegroundColor Cyan
}

# 2. Find all java files
$javaFiles = Get-ChildItem -Path "src" -Filter "*.java"
if ($javaFiles.Count -eq 0) {
    Write-Host "No Java files found in src/ directory!" -ForegroundColor Yellow
    exit
}

# 3. Process each file
$tableRows = @()
$sl = 1
$hasError = $false

foreach ($file in $javaFiles) {
    $filePath = $file.FullName
    $relPath = "src/" + $file.Name
    Write-Host "Checking: $relPath..." -NoNewline

    # Compile check
    $status = "Pass"
    if ($compilerFound) {
        # Compile into current directory temporarily
        $compileOutput = & $javacPath $filePath -d . 2>&1 | Out-String
        if ($LASTEXITCODE -ne 0) {
            Write-Host " FAIL" -ForegroundColor Red
            Write-Host $compileOutput -ForegroundColor DarkRed
            $status = "Fail"
            $hasError = $true
        } else {
            Write-Host " OK" -ForegroundColor Green
        }
    } else {
        Write-Host " Skipped (No compiler)" -ForegroundColor Yellow
    }

    # Parse headers
    $content = Get-Content $filePath
    $topic = $file.BaseName
    $description = "No description provided."
    $category = "Uncategorized"

    foreach ($line in $content) {
        if ($line -match "^\s*//\s*TCS PRA Practice:\s*(.+)$") {
            $topic = $Matches[1].Trim()
        } elseif ($line -match "^\s*//\s*Description:\s*(.+)$") {
            $description = $Matches[1].Trim()
        } elseif ($line -match "^\s*//\s*Category:\s*(.+)$") {
            $category = $Matches[1].Trim()
        }
    }

    # Create link relative to repository root
    $githubLink = "src/" + $file.Name
    
    $statusEmoji = if ($status -eq "Pass") { "✅ Passing" } else { "❌ Failing" }
    
    # Escape markdown pipes
    $description = $description -replace '\|', '\|'
    $category = $category -replace '\|', '\|'

    $row = "| $sl | [$topic]($githubLink) | $description | $category | $statusEmoji |"
    $tableRows += $row
    $sl++
}

# Clean up any class files generated in root or src during compilation check
Remove-Item *.class -ErrorAction SilentlyContinue
Remove-Item src/*.class -ErrorAction SilentlyContinue
Remove-Item -Recurse -Force *.class -ErrorAction SilentlyContinue

if ($hasError) {
    Write-Host "`nError: One or more Java files failed compilation. Please fix the errors before pushing." -ForegroundColor Red
    exit 1
}

# 4. Update README.md
$readmePath = "README.md"
if (Test-Path $readmePath) {
    $readmeContent = Get-Content $readmePath -Raw
    
    $tableHeader = "| Sl No | Program / Class | Description | Category | Status |`n| :--- | :--- | :--- | :--- | :---: |"
    $tableBody = ($tableRows -join "`n")
    $newTable = "<!-- PRACTICE_LIST_START -->`n$tableHeader`n$tableBody`n<!-- PRACTICE_LIST_END -->"
    
    $updatedReadme = $readmeContent -replace "(?s)<!-- PRACTICE_LIST_START -->.*?<!-- PRACTICE_LIST_END -->", $newTable
    $updatedReadme | Set-Content $readmePath -NoNewline
    Write-Host "README.md practice table updated successfully." -ForegroundColor Green
} else {
    Write-Host "README.md not found! Skipping table update." -ForegroundColor Yellow
}

# 5. Git Sync
Write-Host "`nSyncing with Git..." -ForegroundColor Cyan
git add .
git commit -m $CommitMessage

# Check if there is an upstream branch set, or just push to main
$currentBranch = (git branch --show-current).Trim()
Write-Host "Pushing to remote 'origin' on branch '$currentBranch'..." -ForegroundColor Cyan
git push origin $currentBranch

if ($LASTEXITCODE -eq 0) {
    Write-Host "Sync Completed Successfully!" -ForegroundColor Green
} else {
    Write-Host "Failed to push to remote. Please check your network connection or repository permissions." -ForegroundColor Red
}
