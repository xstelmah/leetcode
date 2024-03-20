package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task2509 {

    @Test
    void example1() {
        var n = 3;
        var queries = new int[][]{{5, 3}, {4, 7}, {2, 3}};
        var response = cycleLengthQueries(n, queries);
        Assertions.assertArrayEquals(new int[]{4, 5, 3}, response);
    }

    @Test
    void example2() {
        var n = 2;
        var queries = new int[][]{{1, 2}};
        var response = cycleLengthQueries(n, queries);
        Assertions.assertArrayEquals(new int[]{2}, response);
    }

    public int[] cycleLengthQueries(int n, int[][] queries) {
        var answer = new int[queries.length];
        var left = 0;
        var right = 0;
        for (int i = 0; i < queries.length; i++) {
            answer[i] = 1;
            left = queries[i][0];
            right = queries[i][1];
            while (left != right) {
                if (left > right) {
                    left >>= 1;
                    answer[i]++;
                } else {
                    right >>= 1;
                    answer[i]++;
                }
            }
        }
        return answer;
    }

}
