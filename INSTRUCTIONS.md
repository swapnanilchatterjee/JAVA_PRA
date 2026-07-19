# Git Sync & Compilation Verification Guide

This file serves as a reference guide for managing, verifying, and syncing your TCS PRA Java practice sets with GitHub. 

---

## 📋 Standards for Java Source Files

For the automation script to successfully parse and build the index table in the `README.md`, all `.java` files added inside the `src/` directory should follow this header comment template:

```java
// TCS PRA Practice: <Short Name/Title of the Program>
// Description: <Brief description of the logic or problem statement>
// Category: <Category such as Hashing / Map, Basic Mathematics, String Manipulation, Arrays, etc.>

import java.util.*;
public class MyProgram {
    ...
}
```

---

## 🛠️ Syncing and Verifying Code

To compile, verify, update the index, and push your work to your GitHub repository:

### Option 1: Automated Sync (Recommended)
Open PowerShell in this directory and execute the sync script:
```powershell
powershell -ExecutionPolicy Bypass -File .\sync.ps1 -CommitMessage "Add your custom commit message here"
```

This script automatically:
1. Detects your Java compiler (e.g. IntelliJ's JBR JDK or system JDK).
2. Performs compilation checks on all files in `src/`.
3. Blocks the sync process if there are compilation errors, showing you the line numbers to fix.
4. Dynamically builds and updates the index table in `README.md`.
5. Cleans up temporary `.class` files.
6. Commits and pushes the code directly to `https://github.com/swapnanilchatterjee/JAVA_PRA.git`.

### Option 2: Manual Commands
If you prefer executing the commands step-by-step:

1. **Verify Compilation**:
   ```powershell
   & "C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.3.5\jbr\bin\javac.exe" src/*.java
   ```
2. **Clean up Class Files**:
   ```powershell
   Remove-Item src/*.class -ErrorAction SilentlyContinue
   ```
3. **Commit & Push**:
   ```powershell
   git add .
   git commit -m "Your commit message"
   git push origin main
   ```

---

## 🔗 Important Local File Links
* [Source Directory](file:///C:/Users/Me/Documents/Placement/Java/PRA_prep/src/)
* [Sync Script](file:///C:/Users/Me/Documents/Placement/Java/PRA_prep/sync.ps1)
* [README.md](file:///C:/Users/Me/Documents/Placement/Java/PRA_prep/README.md)
* [.gitignore](file:///C:/Users/Me/Documents/Placement/Java/PRA_prep/.gitignore)
