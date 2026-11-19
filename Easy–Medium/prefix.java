/*
------------------------------------------ Longest Common Prefix ----------------------------------
Easy

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 ---------------------------------------------------------------------------------------------------
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder pre = new StringBuilder();

        Arrays.sort(strs);
    
        String f = strs[0];
        String l = strs[strs.length - 1];

        for (int i = 0; i < Math.min(f.length(), l.length()); i++) {
            if (f.charAt(i) != l.charAt(i)) {
                return pre.toString();
            }

            pre.append(f.charAt(i));
        }

        return pre.toString();
    }
}


class Solution {
    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        String f = strs[0];
        String l = strs[strs.length - 1];

        String pre = "";

        for (int i = 0; i < Math.min(f.length(), l.length()); i++) {

            if (f.charAt(i) != l.charAt(i)) {
                return pre;
            }

            pre += f.charAt(i);
        }

        return pre;
    }
}
