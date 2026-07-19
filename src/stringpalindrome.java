// TCS PRA Practice: String Palindrome Checker
// Description: Checks if a given string is a palindrome (reads same forward and backward), ignoring case.
// Category: String Manipulation

import java.util.*;
public class stringpalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        String rev = new StringBuilder(str).reverse().toString();
        System.out.println(str.equals(rev) ? "Yes" : "No");
        sc.close();
    }
}
