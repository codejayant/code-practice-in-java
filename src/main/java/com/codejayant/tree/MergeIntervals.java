package com.codejayant.tree;

import java.util.*;

/**
 * Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
 *
 * @see <a href="https://www.educative.io/courses/grokking-the-coding-interview/3jyVPKRA8yx">Educative Problem</a>
 * @see <a href="https://leetcode.com/problems/merge-intervals/">LeetCode Problem</a>
 */
class MergeIntervals {

    private static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        int size = intervals.size();

        if (size < 2) {
            return intervals;
        }

        // sort intervals by start value
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);

        mergedIntervals.add(intervals.get(0));
        int mergedIndex = 0;

        for (int i = 1; i < size; i++) {
            Interval current = intervals.get(i);

            if (current.start < mergedIntervals.get(mergedIndex).end) {
                mergedIntervals.get(mergedIndex).end = Math.max(current.end, mergedIntervals.get(mergedIndex).end);
            } else {
                mergedIntervals.add(current);
                mergedIndex++;
            }

        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
