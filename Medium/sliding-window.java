
/*
--------------------- Problem 2 — Longest Substring Without Repeating Characters -----------------
Medium

Given a string s, find the length of the longest substring without repeating characters.
A substring must contain consecutive characters.

Example 1
s = "abcabcbb"
Output: 3

Explanation: The longest substring without repeating characters is "abc".
*/
public int lengthOfLongestSubstring(String s) {

    Map<Character, Integer> map = new HashMap<>();

    int left = 0;
    int max = 0;

    for (int right = 0; right < s.length(); right++) {

        char c = s.charAt(right);
        left = Math.max(left, map.getOrDefault(c, -1) + 1);
        map.put(c, right);
        max = Math.max(max, right - left + 1);
    }

    return max;
}

public int lengthOfLongestSubstring(String s) {

    Map<Character, Integer> map = new HashMap<>();

    int left = 0;
    int max = 0;

    for (int right = 0; right < s.length(); right++) {

        char current = s.charAt(right);

        if (map.containsKey(current)) {
            left = Math.max(left, map.get(current) + 1);
        }

        map.put(current, right);

        max = Math.max(max, right - left + 1);
    }

    return max;
}
