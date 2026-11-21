/*
-------------------- Minimum Number of Swaps to Make the Binary String Alternating ----------------
Medium

Given a binary string s, return the minimum number of character swaps to make it alternating, or -1 
if it is impossible.

The string is called alternating if no two adjacent characters are equal. For example, the strings 
"010" and "1010" are alternating, while the string "0100" is not.

Any two characters may be swapped, even if they are not adjacent.
----------------------------------------------------------------------------------------------------
*/

class Solution {
    public int minSwaps(String s) {
        int count1 = 0, count0 = 0;
        int miss0 = 0, miss1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count1++;
            } else {
                count0++;
            }
        }

        if (Math.abs(count0 - count1) > 1) {
            return -1;
        }

        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != '0') {
                miss0++;
            } else {
                miss1++;
            }
        }

        int min = Math.min(miss0, miss1);

        return count0 == count1
            ? min : count0 > count1
                ? miss0
                : miss1;
    }
}