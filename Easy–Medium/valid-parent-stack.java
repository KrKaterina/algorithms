/*
------------------------------------- Valid Parentheses --------------------------------------------
Easy

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
----------------------------------------------------------------------------------------------------
*/

class Solution {
    public boolean isValid(String st) {

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < st.length(); i++) {

            char c = st.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                s.push(c);

            } else {
                if (s.isEmpty()) {
                    return false;
                }

                char top = s.peek();

                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;

                s.pop();
            }
        }

        return s.isEmpty();
    }
}
