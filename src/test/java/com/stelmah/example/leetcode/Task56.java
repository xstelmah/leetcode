package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class Task56 {

    @Test
    void example1() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        var start = intervals[0][0];
        var top = intervals[0][1];
        var answers = new ArrayList<int[]>();

        var index = 1;
        while (index < intervals.length) {
            if (intervals[index][0] <= top) {
                top = Math.max(top, intervals[index][1]);
            } else {
                answers.add(new int[]{start, top});
                start = intervals[index][0];
                top = intervals[index][1];
            }
            index++;
        }
        answers.add(new int[]{start, top});
        return answers.toArray(new int[answers.size()][2]);
    }

}
