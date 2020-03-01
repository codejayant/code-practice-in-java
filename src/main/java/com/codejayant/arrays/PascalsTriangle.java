package com.codejayant.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * @link https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(generate(0));
        System.out.println(generate(1));
        System.out.println(generate(2));
        System.out.println(generate(5));
    }

    private static List<List<Integer>> generate(int numRows) {

        Integer[][] result = new Integer[numRows][];

        if (numRows == 0) {
            return new ArrayList<>();
        } else if (numRows == 1) {
            Integer[] temp1 = {1};
            result[0] = temp1;
            return arrayAsList(result);
        }


        Integer[] temp1 = {1};
        Integer[] temp2 = {1, 1};
        result[0] = temp1;
        result[1] = temp2;

        for (Integer i = 2; i < numRows; i++) {
            Integer[] temp = new Integer[i + 1];
            for (Integer j = 0; j <= i; j++) {

                if (j == 0 || j.equals(i)) {
                    temp[j] = 1;
                } else {
                    temp[j] = result[i - 1][j - 1] + result[i - 1][j];
                }
            }
            result[i] = temp;
        }

        return arrayAsList(result);
    }

    private static List<java.util.List<Integer>> arrayAsList(Integer[][] arrayRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (Integer[] row: arrayRows) {
            list.add(Arrays.asList(row));
        }

        return list;
    }

}
