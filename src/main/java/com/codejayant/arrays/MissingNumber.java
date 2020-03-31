package com.codejayant.arrays;

/**
 * We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’. Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
 *
 * Example 1:
 *
 * Input: [4, 0, 3, 1]
 * Output: 2
 * Example 2:
 *
 * Input: [8, 3, 5, 2, 4, 6, 0, 1]
 * Output: 7
 *
 * @see <a href="https://www.educative.io/courses/grokking-the-coding-interview/JPnp17NYXE9">Problem</a>
 */
class MissingNumber {

    public static void main(String[] args) {
        System.out.println(MissingNumber.findMissingNumber(new int[]{1, 2, 3}));
        System.out.println(MissingNumber.findMissingNumber(new int[]{4, 0, 3, 1}));
        System.out.println(MissingNumber.findMissingNumber(new int[]{8, 3, 5, 2, 4, 6, 0, 1}));
    }

    /**
     * Finding the missing number.
     * T: O(n)
     * S: O(1)
     *
     * @param nums input array
     * @return missing number
     */
    private static int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            // use length value as a placeholder in the missing index field.
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }

        // find the first number missing from its index, that will be our required number.
        // Otherwise length is the missing number.
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

