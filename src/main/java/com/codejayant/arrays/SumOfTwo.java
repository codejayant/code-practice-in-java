package com.codejayant.arrays;

import org.junit.Assert;

import java.util.HashSet;

/**
 * For a given two array of integer, find out if there are integers in each array whose sum is equal to a given value.
 * If yes, return true otherwise false.
 *
 * Example:
 * Input: [1, 2, 3], [10, 20, 30, 40], 42 (value)
 * Output: true
 * Explanation: 2 (from first array) + 40 (from second array) = 42
 */
public class SumOfTwo {

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3};
        Integer[] b = {10, 20, 30, 40};

        Assert.assertTrue(sumOfTwo(a, b, 42));
        Assert.assertFalse(sumOfTwo(a, b, 45));
        Assert.assertTrue(sumOfTwo(a, b, 43));

    }

    /**
     * Calculate compliment from first array, save in a HashSet and check if the element exists by comparing with second array elements.
     * <p>
     * Time Complexity: O(n) since there are two sequential loop execution
     * <p>
     * Space Complexity: O(n) since a new DS HashSet is introduced saving all complimentary elements from Array first
     *
     * @param a first input array
     * @param b second input array
     * @param value input sum value
     * @return true if some element in First Array + some element in Second Array = {@code array}
     */
    private static boolean sumOfTwo(Integer[] a, Integer[] b, int value) {
//        HashSet<Integer> complimentA = Arrays.stream(a)
//                .map(integer -> value - integer)
//                .collect(Collectors.toCollection(HashSet::new));

        HashSet<Integer> complimentA = new HashSet<>();
        for (Integer integer : a) {
            complimentA.add(value - integer);
        }

        for (Integer integer : b) {
            if (complimentA.contains(integer)) {
                return true;
            }
        }
        return false;
    }

}
