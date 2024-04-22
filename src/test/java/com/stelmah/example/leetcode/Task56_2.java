package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class Task56_2 {

    @Test
    void example1() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    /** Beats 100% */
    public int[][] merge(int[][] intervals) {
        var answers = new ArrayList<int[]>();
        var min = 10_000;
        var max = 0;
        for (int i = 0; i < intervals.length; i++) {
            min = Math.min(intervals[i][0], min);
            max = Math.max(intervals[i][1], max);
        }


        var starts = new int[max - min + 1];
        var ends = new int[max - min + 1];
        for (int i = 0; i < intervals.length; i++) {
            starts[intervals[i][0] - min]++;
            ends[intervals[i][1] - min]++;
        }

        var cnt = 0;

        Integer start = null;

        for (int i = 0; i <= max - min; i++) {
            if (starts[i] > 0) {
                if (start != null) {
                    cnt += starts[i];
                } else {
                    start = i;
                    cnt = starts[i];
                }
            }

            if (ends[i] > 0) {
                cnt -= ends[i];

                if (cnt == 0) {
                    answers.add(new int[]{start + min, i + min});
                    start = null;
                }
            }
        }

        return answers.toArray(new int[answers.size()][2]);
    }

}
