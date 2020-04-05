package com.codejayant.twopointers;

import org.junit.Assert;

import java.util.Arrays;

/**
 * Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet.
 * If there are more than one such triplet, return the sum of the triplet with the smallest sum.
 * <p>
 * Example 1:
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 * <p>
 * Example 2:
 * Input: [-3, -1, 1, 2], target=1
 * Output: 0
 * Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
 * <p>
 * Example 3:
 * Input: [1, 0, 1, 1], target=100
 * Output: 3
 * Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 *
 * @see <a href="https://www.educative.io/courses/grokking-the-coding-interview/3YlQz7PE7OA">Educative Problem</a>
 */
public class TripletSumCloseToTarget {

    public static void main(String[] args) {
        doTest();
    }

    private static void doTest() {

        // Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
        Assert.assertEquals(1, searchTriplet(new int[]{-2, 0, 1, 2}, 2));

        // Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
        Assert.assertEquals(0, searchTriplet(new int[]{-3, -1, 1, 2}, 1));

        // Explanation: The triplet [1, 1, 1] has the closest sum to the target.
        Assert.assertEquals(3, searchTriplet(new int[]{1, 0, 1, 1}, 100));

    }

    private static int searchTriplet(int[] arr, int targetSum) {

        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                // comparing the sum of three numbers to the 'targetSum' can cause overflow
                // so, we will try to find a target difference
                int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
                if (targetDiff == 0) //  we've found a triplet with an exact sum
                    return targetSum - targetDiff; // return sum of all the numbers

                // the second part of the above 'if' is to handle the smallest sum when we have more than one solution
                if (Math.abs(targetDiff) < Math.abs(smallestDifference)
                        || (Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference))
                    smallestDifference = targetDiff; // save the closest and the biggest difference

                if (targetDiff > 0)
                    left++; // we need a triplet with a bigger sum
                else
                    right--; // we need a triplet with a smaller sum
            }
        }
        return targetSum - smallestDifference;
    }

}
