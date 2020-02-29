package com.codejayant.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * @link https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArraysWithDuplicate {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(IntersectionOfTwoArraysWithDuplicate.intersect(nums1, nums2)));
    }

    /**
     * Find intersection.
     * T: O(n + m)
     * S: O(min(n, m))
     *
     * @param nums1 array 1
     * @param nums2 array 2
     * @return result array
     */
    private static int[] intersect(int[] nums1, int[] nums2) {

        // use smaller array for HashMap and larger to compare to save space
        if (nums1.length > nums2.length) {
            // call same method reversing the input
            return intersect(nums2, nums1);
        }

        // create a map and save numbers with count
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int counter = 0;

        // check if number from array 2 present in map. If yes, add to result and decrease the count of the number in the map.
        for (int n : nums2) {
            // this way (getOrDefault) code won't have to handle null
            int count = map.getOrDefault(n, 0);

            if (count > 0) {
                // use same array 1 to save result. It will save space.
                nums1[counter++] = n;

                // put back the number with previous count minus 1
                map.put(n, count - 1);
            }
        }

        // return subarray which is result
        return Arrays.copyOfRange(nums1, 0, counter);
    }

    /**
     * find intersect using array sort
     * T: O(nlogn + mlogm)
     * S: O(1)
     *
     * @param nums1 array 1
     * @param nums2 array 2
     * @return result array
     */
    private static int[] findIntersectUsingSorting(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }


}
