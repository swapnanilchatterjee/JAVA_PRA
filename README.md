# TCS PRA Exam Preparation (Java)

This repository is dedicated to preparing for the **TCS Practical Assessment (PRA) Exam**. It contains clean, compiled-and-tested Java solutions to common PRA coding problems.

---

## 🚀 Repository Highlights

* **Automated Indexing**: Program descriptions and categories are parsed dynamically from the source files.
* **Syntax Validation**: A custom synchronization script compiles and validates every solution before it gets pushed to GitHub, ensuring no broken code is committed.
* **Pre-configured Environment**: Works seamlessly with JetBrains Runtime compiler or system JDK.
* **Master Handbook Included**: [TCS IPA Java Practice Master Handbook](TCS_IPA_Java_Handbook_Corrected_Full.pdf) is available in the repository root for quick revision of 35-mark coding patterns.

---

## 📂 Solved Practice Programs

<!-- PRACTICE_LIST_START -->
| Sl No | Program / Class | Description | Category | Status |
| :--- | :--- | :--- | :--- | :---: |
| 1 | [Average of N Numbers](src/average.java) | Computes the mathematical average of N inputs and formats the output to 2 decimal places. | Basic Mathematics | ✅ Passing |
| 2 | [Course Administration System](src/Course_Administration.java) | Calculates average fees by course administrator and sorts courses by fee for ratings within a threshold. | Core Java / OOPs | ✅ Passing |
| 3 | [Fruits Management System](src/Fruits_Management_System.java) | Finds the fruit with the maximum price having a rating greater than a specified threshold. | Core Java / OOPs | ✅ Passing |
| 4 | [Character Frequency Count](src/HashMap.java) | Counts and displays the frequency of each character in a given string, ignoring spaces and maintaining insertion order. | Hashing / Map | ✅ Passing |
| 5 | [Laptop Management System](src/Laptop_Management.java) | Filters laptops by brand with rating > 3, and searches/sorts laptops by OS type in descending order of ID. | Core Java / OOPs | ✅ Passing |
| 6 | [Medicine Inventory Management](src/Medicine_Inventory.java) | Retrieves and sorts prices of medicines matching a specified disease in ascending order. | Core Java / OOPs | ✅ Passing |
| 7 | [Reverse Words in String](src/reverseword.java) | Reverses the order of words in a given space-separated sentence. | String Manipulation | ✅ Passing |
| 8 | [Second Largest Element](src/SecondLargest.java) | Finds the second largest element in an array of N integers after sorting. | Arrays | ✅ Passing |
| 9 | [Sports Analytics System](src/Sports_Analytics.java) | Finds the player with the lowest runs for a given player type and calculates average runs for a specified match type. | Core Java / OOPs | ✅ Passing |
| 10 | [String Palindrome Checker](src/stringpalindrome.java) | Checks if a given string is a palindrome (reads same forward and backward), ignoring case. | String Manipulation | ✅ Passing |
| 11 | [Static Keyword Demonstration](src/TestStatic.java) | Demonstrates static initialization blocks, static variables (instance counter), static methods, and constructor execution order. | Core Java / OOPs | ✅ Passing |
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
