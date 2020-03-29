package com.codejayant.arrays;

import java.util.Arrays;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 * @see <a href="https://leetcode.com/problems/product-of-array-except-self/">https://leetcode.com/problems/product-of-array-except-self/</a>
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    /**
     * Create two result set. One will store product value of left hand side and another will store product value of right hand side.
     * T: O(n)
     * S: O(n)
     *
     * @param nums input array
     * @return result array
     */
    private static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] l = new int[len];
        int[] r = new int[len];

        l[0] = 1;
        r[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            l[i] = l[i - 1] * nums[i - 1];
            r[len - i - 1] = r[len - i] * nums[len - i];
        }

        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = l[i] * r[i];
        }

        return result;
    }

    /**
     * Create one answer set. On first iteration, calculate all left hand side product and save it.
     * On second iteration, calculate all right hand side value and multiple with left product value saved in result array and save it back.
     * T: O(n)
     * S: O(1)
     *
     * @param nums input array
     * @return result array
     */
    public int[] productExceptSelf1(int[] nums) {

        // The length of the input array
        int length = nums.length;

        // Final answer array to be returned
        int[] answer = new int[length];

        // answer[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {

            // answer[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R would be 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {

            // For the index 'i', R would contain the
            // product of all elements to the right. We update R accordingly
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }

}
