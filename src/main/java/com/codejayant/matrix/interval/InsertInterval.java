package com.codejayant.matrix.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * @implNote this is implemented using array.
 * @see <a href="https://leetcode.com/problems/insert-interval/">LeetCode Problem</a>
 */
public class InsertInterval {
    private static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();

        if (intervals == null || intervals.length < 1) {
            mergedIntervals.add(newInterval);
            return mergedIntervals.toArray(new int[0][]);
        }

        int size = intervals.length;
        boolean isIntervalAdded = false;

        for (int i = 0; i < size; i++) {
            int[] currentInterval = intervals[i];

            if (newInterval[0] <= currentInterval[1]) {
                // merge here
                int start = Math.min(currentInterval[0], newInterval[0]);
                int end = Math.max(currentInterval[1], newInterval[1]);

                int[] intervalToInsert = new int[]{start, end};
                mergedIntervals.add(intervalToInsert);
                isIntervalAdded = true;

                // check for other element in original input if they need to merge with this new created interval.
                for (; ++i < size; ) {
                    int[] internalCurrentInterval = intervals[i];
                    int[] intervalInserted = mergedIntervals.get(mergedIntervals.size() - 1);

                    if (internalCurrentInterval[0] <= intervalInserted[1]) {
                        // need to merge
                        start = Math.min(internalCurrentInterval[0], intervalInserted[0]);
                        end = Math.max(internalCurrentInterval[1], intervalInserted[1]);

                        intervalToInsert = new int[]{start, end};
                        mergedIntervals.remove(mergedIntervals.size() - 1);
                        mergedIntervals.add(intervalToInsert);
                    } else {
                        // merge is not needed. Can get out of this loop as well.
                        mergedIntervals.add(internalCurrentInterval);
                        break;
                    }
                }

            } else {
                // no merge
                mergedIntervals.add(currentInterval);
            }
        }
        if (!isIntervalAdded) {
            mergedIntervals.add(newInterval);
        }
        return mergedIntervals.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] input;

        input = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        System.out.print("Intervals after inserting the new interval: ");
        for (int[] interval : InsertInterval.insert(input, new int[]{4, 8}))
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        System.out.println();

        // TODO: this use case is not working.
        input = new int[][]{{1, 5}};
        System.out.print("Intervals after inserting the new interval: ");
        for (int[] interval : InsertInterval.insert(input, new int[]{0, 0}))
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        System.out.println();

//        input = new int[][]{{1, 3}, {5, 7}, {8, 12}};
//        System.out.print("Intervals after inserting the new interval: ");
//        for (int[] interval : InsertInterval.insert(input, new int[]{4, 6}))
//            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
//        System.out.println();
//
//        input = new int[][]{{1, 3}, {5, 7}, {8, 12}};
//        System.out.print("Intervals after inserting the new interval: ");
//        for (int[] interval : InsertInterval.insert(input, new int[]{4, 10}))
//            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
//        System.out.println();
//
//        input = new int[][]{{2, 3}, {5, 7}};
//        System.out.print("Intervals after inserting the new interval: ");
//        for (int[] interval : InsertInterval.insert(input, new int[]{1, 4}))
//            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
//        System.out.println();

    }
}
