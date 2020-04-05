package com.codejayant.twopointers;

import org.junit.Assert;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * Example:
 *
 * Input: nums = [-2,0,1,3], and target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 *              [-2,0,1]
 *              [-2,0,3]
 *
 * @see <a href="https://leetcode.com/problems/3sum-smaller/">LeetCode Problem</a>
 * @see <a href="https://www.educative.io/courses/grokking-the-coding-interview/gxk639mrr5r">Educative Problem</a>
 */
public class TripletWithSmallerSum {

    public static void main(String[] args) {
        Assert.assertEquals(2, TripletWithSmallerSum.threeSumSmaller(new int[]{-1, 0, 2, 3}, 3));
        Assert.assertEquals(4, TripletWithSmallerSum.threeSumSmaller(new int[] { -1, 4, 2, 1, 3 }, 5));
    }

    /**
     * find smaller by creating target diff and then compare target diff with remaining element using 2 pointers.
     * T: O(n2) sorting need O(nlogn) but there is a nested loop O(n2)
     * S: O(n) : sorting need n space
     *
     * @param nums number array input
     * @param target target value
     * @return count of triplet whose sum is less than the target
     */
    private static int threeSumSmaller(int[] nums, int target) {
        int start = 0;
        int count = 0;

        Arrays.sort(nums);

        while (start < nums.length - 2) {
            count += findDupletCount(nums, target - nums[start], start + 1);
            // System.out.println("total count: " + count);
            start++;
        }

        return count;
    }

    /**
     * target is reduced.
     *
     * @param nums original number input
     * @param reducedTarget reduced target value: diff of original target and element at position "start - 1"
     * @param start starting index for this comparision
     * @return count of duplet whose sum is less than the {@code reducedTarget}
     */
    private static int findDupletCount(int[] nums, int reducedTarget, int start) {
        int end = nums.length - 1;
        int count = 0;

        while (start < end) {
            int diff = reducedTarget - nums[start] - nums[end];
            if (diff > 0) {
                count += end - start;
                start++;
            } else {
                end--;
            }
        }
        // System.out.println("temp count: " + count);
        return count;
    }
}
