package com.codejayant.linkedList;

import com.codejayant.utils.Interval;

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
 * @implNote this is implemented using list.
 * @see <a href="https://leetcode.com/problems/insert-interval/">LeetCode Problem</a>
 * @see <a href="https://www.educative.io/courses/grokking-the-coding-interview/3jKlyNMJPEM">Educative Problem</a>
 */
class InsertInterval {

    /**
     * Insert element in proper interval and merge others if necessary.
     * T: O(n) since input is already sorted, only need to iterate over elements once
     * S: O(n) : from list of merged interval.
     *
     * @param intervals   input
     * @param newInterval interval to insert
     * @return new interval list
     */
    private static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();

        if (intervals == null) {
            mergedIntervals.add(newInterval);
            return mergedIntervals;
        }

        int size = intervals.size();
        boolean isIntervalAdded = false;

        for (int i = 0; i < size; i++) {
            Interval currentInterval = intervals.get(i);

            if (newInterval.start < currentInterval.end) {
                // merge here
                int start = Math.min(currentInterval.start, newInterval.start);
                int end = Math.max(currentInterval.end, newInterval.end);

                Interval intervalToInsert = new Interval(start, end);
                mergedIntervals.add(intervalToInsert);
                isIntervalAdded = true;

                // check for other element in original input if they need to merge with this new created interval.
                for (; ++i < size; ) {
                    Interval internalCurrentInterval = intervals.get(i);
                    Interval intervalInserted = mergedIntervals.get(mergedIntervals.size() - 1);

                    if (internalCurrentInterval.start < intervalInserted.end) {
                        // need to merge
                        start = Math.min(internalCurrentInterval.start, intervalInserted.start);
                        end = Math.max(internalCurrentInterval.end, intervalInserted.end);

                        intervalToInsert = new Interval(start, end);
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
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));

        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
