package com.codejayant.matrix.interval;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * @see <a href="https://leetcode.com/problems/merge-intervals/">Problem</a>
 * @see <a href="https://www.youtube.com/watch?v=qKczfGUrFY4">Youtube Solution</a>
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expectedOutput = {{1, 6}, {8, 10}, {15, 18}};

        Assert.assertArrayEquals(expectedOutput, mergeIntervals(intervals));
    }

    /**
     * merge intervals.
     * T: O(nlogn)
     *
     * @param intervals input intervals
     * @return result merged intervals
     */
    private static int[][] mergeIntervals(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        // sort the array based on first index's element.
        // T: O(nlogn)
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        // result list since length of result is unknown
        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        // add the first interval to result array
        result.add(currentInterval);

        // T: O(n)
        for (int[] interval : intervals) {
            int currentBegin = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            // overlap can happen if current end index value is greater than next begin index value
            if (currentEnd >= nextBegin) {
                // this line also update value in result list since currentInterval is referenced by memory in result list as well
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // update currentInterval with new interval since there is no overlapping
                currentInterval = interval;

                // add the new currentInterval to the result list
                result.add(currentInterval);
            }
        }


        // convert list to array before returning
        return result.toArray(new int[result.size()][]);
    }


}
