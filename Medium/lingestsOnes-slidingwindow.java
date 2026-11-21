/*
---------------------------------------  Max Consecutive Ones III -----------------------------------
Medium

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array
if you can flip at most k 0's.
-----------------------------------------------------------------------------------------------------
*/

class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int max =0;
        int zero =0;

        for(int r=0;r<nums.length;r++){
            if(nums[r]==0){
                zero++;
            }

            while (zero > k) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }

            max = Math.max(max,r-left+1);
        }

        return max;
    }
}