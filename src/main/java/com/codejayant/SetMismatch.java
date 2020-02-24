package com.codejayant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 * <p>
 * Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
 * <p>
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Note:
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order.
 *
 * @link https://leetcode.com/problems/set-mismatch/
 */
public class SetMismatch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    /**
     * find duplicate and missing number.
     * T: O(n)
     * S: O(n)
     *
     * @param nums number array
     * @return array consist of duplicate number and missing number
     */
    private static int[] findErrorNums(int[] nums) {
        int len = nums.length;

        int total = len * (len + 1) / 2;
        int sum = 0, duplicate = 0;
        Set<Integer> storage = new HashSet<>();

        for (int num : nums) {
            sum += num;

            if (storage.contains(num)) {
                duplicate = num;
            } else {
                storage.add(num);
            }
        }

        return new int[]{duplicate, total - sum + duplicate};
    }

}
