package com.codejayant.arrays.multiarray;

import org.junit.Assert;

/**
 * Note: Try to solve this task in-place (with O(1) additional memory), since this is what you'll be asked to do during an interview.
 *
 * You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).
 *
 * Example
 *
 * For
 *
 * a = [[1, 2, 3],
 *      [4, 5, 6],
 *      [7, 8, 9]]
 * the output should be
 *
 * rotateImage(a) =
 *     [[7, 4, 1],
 *      [8, 5, 2],
 *      [9, 6, 3]]
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] array.array.integer a
 *
 * Guaranteed constraints:
 * 1 ≤ a.length ≤ 100,
 * a[i].length = a.length,
 * 1 ≤ a[i][j] ≤ 104.
 *
 * [output] array.array.integer
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Assert.assertEquals(rotateImage(a), rotateImage1(a));
    }


    /**
     * rotate 2D array using a new array storage
     * <p>
     * T: O(n2)
     * <p>
     * S: O(n)
     * <p>
     *
     * @param a array in question
     * @return rotated array
     */
    static int[][] rotateImage(int[][] a) {
        int len = a.length;
        int[][] sol = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sol[j][len - 1 - i] = a[i][j];
            }
        }
        return sol;
    }

    /**
     * rotate 2D array in-place memory
     * <p>
     * T: O(n2)
     * <p>
     * S: O(1)
     * <p>
     *
     * @param a array in question
     * @return rotated array
     */
    static int[][] rotateImage1(int[][] a) {
        int len = a.length;

        // Step 1: Transpose Matrix
        // exchange element diagonally
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        // Step 2: flip Matrix
        // exchange element in a row
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = a[i][j];
                a[i][j] = a[i][len - 1 - j];
                a[i][len - 1 - j] = temp;
            }
        }
        return a;
    }

}
