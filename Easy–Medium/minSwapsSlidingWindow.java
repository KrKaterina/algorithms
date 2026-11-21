/*
------------------------------ Minimum Swaps to Group All 1's Together ------------------------------- 

Given a binary array nums of length n containing only 0s and 1s. 
In one move, you can swap any two elements in the array (not necessarily adjacent). 
Return the minimum number of swaps required to group all 1s together in any contiguous subarray 
(anywhere in the array, not necessarily at the ends).Signature: public int minSwaps(int[] nums)

Constraints: $1 \le n \le 10^5$, nums[i] \in \{0, 1\}
Example: nums = [1, 0, 1, 0, 1]
Output: 1 (swap nums[0] with nums[3] 
[0, 0, 1, 1, 1]).
[111011]
[1001];

nums = [1, 1, 0, 0, 0, 1, 1]
----------------------------------------------------------------------------------------------------
*/
public int minSwaps(int[] nums) {
    int k = 0;

    for (int num : nums) {
        k += num;
    }

    int ones = 0;

    for (int i = 0; i < k; i++) {
        ones += nums[i];
    }
 
    int maxOnes = ones;

    for (int i = k; i < nums.length; i++) {

        ones += nums[i] - nums[i - k];
        maxOnes = Math.max(maxOnes, ones);
    }

    return k - maxOnes;
}
