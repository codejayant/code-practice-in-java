package com.codejayant.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * @link https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindDuplicateNumberInArray {

    public static void main(String[] args) {

        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate1(nums));
        System.out.println(findDuplicate2(nums));
        System.out.println(findDuplicate3(nums));
    }


    /**
     * find duplicate using pointers. Floyd's Tortoise and Hare (Cycle Detection)
     * Time complexity : O(n)
     * Space complexity : O(1)
     * @param nums input array
     * @return duplicate value
     */
    private static int findDuplicate1(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

    /**
     * find duplicate using sorting.
     * Time complexity : O(nlgn)
     * Space complexity : O(1) or O(n)
     * @param nums input array
     * @return duplicate value
     */
    private static int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }

        return -1;
    }

    /**
     * find duplicate using hash table.
     * Time complexity : O(n)
     * Space complexity : O(n)
     * @param nums input array
     * @return duplicate value
     */
    private static int findDuplicate3(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }
}
