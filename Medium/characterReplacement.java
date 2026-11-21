/*
---------------------------- Longest Repeating Character Replacement -------------------------------
Medium

You are given a string s and an integer k. You can choose any character of the string and change it 
to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing
the above operations.v
----------------------------------------------------------------------------------------------------
*/


class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxFreq = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);

            map.put(current, map.getOrDefault(current, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(current));

            while ((right - left + 1) - maxFreq > k) {

                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}