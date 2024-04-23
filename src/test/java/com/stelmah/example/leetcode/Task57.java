package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class Task57 {

    @Test
    void example1() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] expected = {{1, 2}, {3, 10}, {12, 16}};
        Assertions.assertArrayEquals(expected, insert(intervals, newInterval));
    }

    @Test
    void example2() {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 7};
        int[][] expected = {{1, 7}};
        Assertions.assertArrayEquals(expected, insert(intervals, newInterval));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        var answers = new ArrayList<int[]>();

        var l = newInterval[0];
        var r = newInterval[1];

        var found = false;

        for (int i = 0; i < intervals.length; i++) {
            if (l <= intervals[i][1]) {
                int j = i;
                for (; j < intervals.length; j++) {
                    if (r <= intervals[j][1]) {
                        break;
                    }
                }
                j = (j == intervals.length) ? j - 1 : j;
                var start = Math.min(intervals[i][0], l);
                var end = (intervals[j][0] > r) ? r : Math.max(intervals[j][1], r);
                answers.add(new int[]{start, end});
                j = (end < intervals[j][0]) ? j : j + 1;
                for (; j < intervals.length; j++) {
                    answers.add(intervals[j]);
                }
                found = true;

                break;
            } else {
                answers.add(intervals[i]);
            }
        }
        if (!found) {
            answers.add(newInterval);
        }

        return answers.toArray(new int[answers.size()][2]);
    }


}
