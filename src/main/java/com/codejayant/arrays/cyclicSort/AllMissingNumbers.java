package com.codejayant.arrays.cyclicSort;

import java.util.*;

/**
 * We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
 * The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.
 *
 * @see <a href="https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/">LeetCode Problem</a>
 * @see <a href="https://www.educative.io/courses/grokking-the-coding-interview/Y52qNM0ljWK">Educative Problem</a>
 */
class AllMissingNumbers {

    /**
     * find missing numbers in an array.
     * T: O(n)
     * S: O(1)
     *
     * @param nums input array
     * @return missing numbers
     */
    private static List<Integer> findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                missingNumbers.add(i + 1);

        return missingNumbers;
    }

    /**
     * swap function
     *
     * @param arr input array
     * @param i index one
     * @param j index two
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * find missing numbers in an array using marker if already visited by making visited value as negative.
     * T: O(n)
     * S: O(1)
     *
     * @param nums input array
     * @return missing numbers
     */
    private static List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;

            // change the number to negative if found and is positive.
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        // result list
        List<Integer> disappearedNumberList = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // if positive number, number is missing
            if (nums[i] > 0) {
                disappearedNumberList.add(i + 1);
            }
        }
        return disappearedNumberList;
    }

    public static void main(String[] args) {

        int[] input;

        input = new int[]{2, 3, 1, 8, 2, 3, 5, 1};
        System.out.println("Missing numbers: " + AllMissingNumbers.findNumbers(input));
        System.out.println("Missing numbers: " + AllMissingNumbers.findDisappearedNumbers(input));

        input = new int[]{2, 4, 3, 2};
        System.out.println("Missing numbers: " + AllMissingNumbers.findNumbers(input));
        System.out.println("Missing numbers: " + AllMissingNumbers.findDisappearedNumbers(input));

        input = new int[]{2, 4, 1, 2};
        System.out.println("Missing numbers: " + AllMissingNumbers.findNumbers(input));
        System.out.println("Missing numbers: " + AllMissingNumbers.findDisappearedNumbers(input));

        input = new int[]{2, 3, 2, 1};
        System.out.println("Missing numbers: " + AllMissingNumbers.findNumbers(input));
        System.out.println("Missing numbers: " + AllMissingNumbers.findDisappearedNumbers(input));
    }
}
