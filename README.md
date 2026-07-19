# TCS PRA Exam Preparation (Java)

This repository is dedicated to preparing for the **TCS Practical Assessment (PRA) Exam**. It contains clean, compiled-and-tested Java solutions to common PRA coding problems.

---

## 🚀 Repository Highlights

* **Automated Indexing**: Program descriptions and categories are parsed dynamically from the source files.
* **Syntax Validation**: A custom synchronization script compiles and validates every solution before it gets pushed to GitHub, ensuring no broken code is committed.
* **Pre-configured Environment**: Works seamlessly with JetBrains Runtime compiler or system JDK.

---

## 📂 Solved Practice Programs

<!-- PRACTICE_LIST_START -->
| Sl No | Program / Class | Description | Category | Status |
| :--- | :--- | :--- | :--- | :---: |
| 1 | [Average of N Numbers](src/average.java) | Computes the mathematical average of N inputs and formats the output to 2 decimal places. | Basic Mathematics | ✅ Passing |
| 2 | [Character Frequency Count](src/HashMap.java) | Counts and displays the frequency of each character in a given string, ignoring spaces and maintaining insertion order. | Hashing / Map | ✅ Passing |
| 3 | [Second Largest Element](src/SecondLargest.java) | Finds the second largest element in an array of N integers after sorting. | Arrays | ✅ Passing |
| 4 | [String Palindrome Checker](src/stringpalindrome.java) | Checks if a given string is a palindrome (reads same forward and backward), ignoring case. | String Manipulation | ✅ Passing |
<!-- PRACTICE_LIST_END -->

---

## 🛠️ How to Add & Sync a New Program

1. Create your Java file inside the `src/` directory (e.g., `src/PrimeCheck.java`).
2. Add a standard header comment format at the very top of your file:
   ```java
   // TCS PRA Practice: Prime Number Checker
   // Description: Checks if an input integer is prime or composite.
   // Category: Basic Mathematics
   ```
3. Run the sync script in PowerShell:
   ```powershell
   .\sync.ps1 -CommitMessage "Add Prime Number Checker solution"
   ```

The script will automatically:
* Locate the Java compiler.
* Compile and verify the new code.
* Re-generate the program table in this README.
* Clean up compiled `.class` files.
* Commit and push the changes to your GitHub repository: [JAVA_PRA](https://github.com/swapnanilchatterjee/JAVA_PRA.git).

---

## ⚙️ Requirements & Troubleshooting

* **Java Development Kit (JDK)**: Make sure JDK is installed. The script will automatically search for common installations, including the IntelliJ JetBrains Runtime (`jbr`).
* **Git Authentication**: Make sure you have authenticated Git with your GitHub account (SSH key or credential manager) before running the sync script.
