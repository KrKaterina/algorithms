/*
----------------------------------- Palindrome Number -----------------------------------------
Easy

Given an integer x, return true if x is a palindrome, and false otherwise.

-------------------------------------------------------------------------------------------------
*/

class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0) return false;

        String n = String.valueOf(x);
        int c = 0;

        for (int i = 0; i < n.length() / 2; i++) {
            if (n.charAt(i) == n.charAt(n.length() - 1 - i)) {
                c++;
            }
        }

        return c == n.length() / 2;
    }
}