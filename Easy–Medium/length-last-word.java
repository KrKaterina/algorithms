/*
-------------------------------------- Length of Last Word ----------------------------------------
Easy
 

Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is defined as a maximal substring consisting of non-space characters only.

The string may contain leading or trailing spaces, or multiple spaces between words.


------------------------------------------------------------------------------------------------------
*/

class Solution {
    public int lengthOfLastWord(String s) {

        int end = s.length() - 1;

        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        return end - start;        
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean counting = false;

        for (char c : s.toCharArray()) {
            if (c != ' ') {
                if (!counting) {
                    counting = true;
                    length = 1;
                } else {
                    length++;
                }
            } else {
                counting = false;
            }
        }

        return length;        
    }
}