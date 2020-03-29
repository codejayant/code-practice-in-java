package com.codejayant.matrix;

import org.junit.Assert;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * @see <a href="https://leetcode.com/problems/minimum-path-sum/">LeetCode Problem</a>
 * @see <a href="https://leetcode.com/articles/minimum-path-sum/">LeetCode Article</a>
 */
public class MinPathSum {

    public static void main(String[] args) {
        executeTest();
    }

    private static void executeTest() {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        Assert.assertEquals(7, minPathSum(grid));
    }

    private static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    // last row elements excluding last column's element
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (j == grid[0].length - 1 && i != grid.length - 1) {
                    // last column excluding last row's last element
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (j != grid[0].length - 1 && i != grid.length - 1) {
                    // all other element except last row and last column's elements
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                } else {
                    // element at last row and last column
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

}
