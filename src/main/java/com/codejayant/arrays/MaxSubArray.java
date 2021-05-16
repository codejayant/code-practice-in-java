package com.codejayant.arrays;

import org.junit.Assert;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * @see <a href="https://leetcode.com/problems/maximum-subarray/">https://leetcode.com/problems/maximum-subarray/</a>
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        Assert.assertEquals(8, maxSubArray(nums));
    }

    /**
     * greedy approach
     * <p>
     * Time complexity : O(N) since it's one pass along the array.
     * <p>
     * Space complexity : O(1), since it's a constant space solution.
     *
     * @param nums input array
     * @return max sum
     */
    private static int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < n; i++) {

            // find max between previous sum and previous sum plus current element.
            // If the sum is greater than before, consider the new element otherwise reset the currSum to the element's value.
            currSum = Math.max(nums[i], currSum + nums[i]);

            // compare at every iteration local current sum vs maxSum and update if local sum is greater.
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

}
