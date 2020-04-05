package com.codejayant.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @see <a href="https://leetcode.com/problems/3sum/">LeetCode Problem</a>
 * @see <a href="https://www.educative.io/courses/grokking-the-coding-interview/gxk639mrr5r">Educative Problem</a>
 */
public class TripletSumToZero {

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.threeSum(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(TripletSumToZero.threeSum(new int[]{-5, 2, -1, -2, 3}));
    }

    /**
     * find triplets with sum = 0.
     * T: O(n2)
     * S: O(n)
     *
     * @param nums input array
     * @return triplet list
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        int start = 0;
        List<List<Integer>> result = new LinkedList<>();

        Arrays.sort(nums);

        while (start < len - 2) {
            if (start > 0 && nums[start] == nums[start - 1]) {
                start++;
                continue;
            }
            findPair(nums, -nums[start], start + 1, result);
            start++;
        }
        return result;
    }


    /**
     * find pair with sum equals to target value.
     *
     * @param nums original input array
     * @param target new target value
     * @param start start index
     * @param result list holding triplets value
     */
    private static void findPair(int[] nums, int target, int start, List<List<Integer>> result) {
        int end = nums.length - 1;

        while (start < end) {
            int diff = target - nums[start] - nums[end];

            if (diff == 0) {
                ArrayList<Integer> triplet = new ArrayList<>();
                triplet.add(target * -1);
                triplet.add(nums[start]);
                triplet.add(nums[end]);
                result.add(triplet);
                start++;
                end--;

                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }

                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (diff > 0) {
                start++;
            } else {
                end--;
            }
        }
    }
}
