/*
--------------------------------- Problem 1 — Two Sum ----------------------------------------
Easy–Medium

Problem statement
You are given an integer array nums and an integer target.
Return the indices of the two numbers such that they add up to target.
You may assume that each input has exactly one solution, and you may not use the same element twice.

Example 1
nums = [2, 7, 11, 15]
target = 9
Output: [0, 1]
Because nums[0] + nums[1] = 2 + 7 = 9.
------------------------------------------------------------------------------------------------
*/


public int[] twoSum(int[] nums, int target) {

    Map<Integer, Integer> n = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {

        int mustFound = target - nums[i];

        if (n.containsKey(mustFound)) {
            return new int[] { n.get(mustFound), i };
        }

        n.put(nums[i], i);
    }

    return new int[0];
}
