package com.codejayant.arrays.multiarray;

import java.util.HashSet;
import java.util.Set;

/**
 * Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.
 *
 * Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle according to the layout rules described above. Note that the puzzle represented by grid does not have to be solvable.
 *
 * Example
 *
 * For
 *
 * grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
 *         ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
 *         ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
 *         ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
 *         ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
 *         ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
 *         ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
 *         ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
 *         ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
 * the output should be
 * sudoku2(grid) = true;
 *
 * For
 *
 * grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
 *         ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
 *         ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
 *         ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
 *         ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
 *         ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
 *         ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
 *         ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
 *         ['.', '2', '.', '.', '3', '.', '.', '.', '.']]
 * the output should be
 * sudoku2(grid) = false.
 *
 * The given grid is not correct because there are two 1s in the second column. Each column, each row, and each 3 × 3 subgrid can only contain the numbers 1 through 9 one time.
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] array.array.char grid
 *
 * A 9 × 9 array of characters, in which each character is either a digit from '1' to '9' or a period '.'.
 *
 * [output] boolean
 *
 * Return true if grid represents a valid Sudoku puzzle, otherwise return false.
 *
 * @see <a href="https://app.codesignal.com/interview-practice/task/SKZ45AF99NpbnvgTn/description">CodeSignal Problem</a>
 */
public class sudoku2 {

    public static void main(String[] args) {

    }

    /**
     * My solution using multiple arrays as storage.
     *
     * @param grid input matrix
     * @return true if it is sudoku compatible
     */
    boolean sudoku(char[][] grid) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] m1 = new int[9];
        int[] m2 = new int[9];
        int[] m3 = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (grid[i][j] != '.' && row[grid[i][j] - '1'] != 0) {
                    System.out.println("row: " + i + j);
                    return false;
                } else if (grid[i][j] != '.') {
                    row[grid[i][j] - '1'] = 11;
                }

                if (grid[j][i] != '.' && col[grid[j][i] - '1'] != 0) {
                    System.out.println("col: " + i + j);
                    return false;
                } else if (grid[j][i] != '.') {
                    col[grid[j][i] - '1'] = 11;
                }

                if (grid[i][j] != '.') {
                    if (j / 3 == 0) {
                        if (m1[grid[i][j] - '1'] != 0) {
                            System.out.println("m1: " + i + j);
                            return false;
                        } else {
                            m1[grid[i][j] - '1'] = 11;
                        }
                    } else if (j / 3 == 1) {
                        if (m2[grid[i][j] - '1'] != 0) {
                            System.out.println("m2: " + i + j);
                            return false;
                        } else {
                            m2[grid[i][j] - '1'] = 11;
                        }
                    } else {
                        if (m3[grid[i][j] - '1'] != 0) {
                            System.out.println("m3: " + i + j);
                            return false;
                        } else {
                            m3[grid[i][j] - '1'] = 11;
                        }
                    }
                }
            }

            row = new int[9];
            col = new int[9];

            if ((i + 1) % 3 == 0) {
                m1 = new int[9];
                m2 = new int[9];
                m3 = new int[9];
            }
        }
        return true;
    }

    /**
     * Good solution using HashSet.
     *
     * @param grid input matrix
     * @return true if it is sudoku compatible
     */
    boolean sudoku2(char[][] grid) {
        int n = grid.length;

        Set<String> set = new HashSet<>();

        for (int row = 0; row < n ; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in row " + row))
                    return false;
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in col " + col))
                    return false;
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in square " + row/3 + " " + col/3))
                    return false;
            }
        }

        return true;
    }

}
