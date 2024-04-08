
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;


class Task2070 {


    @Test
    void example1() {
        int[][] items = {{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
        int[] queries = {1, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(new int[]{2, 4, 5, 5, 6, 6}, maximumBeauty(items, queries));
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(o -> o[0]));
        int[] maxs = new int[items.length];
        int[] answers = new int[queries.length];
        maxs[0] = items[0][1];
        for (int i = 1; i < maxs.length; i++) {
            maxs[i] = Math.max(maxs[i - 1], items[i][1]);
        }
        for (int i = 0; i < queries.length; i++) {
            var l = 0;
            var r = items.length - 1;
            while (l < r) {
                var m = (l + r + 1) / 2;
                if (queries[i] < items[m][0]) {
                    r = m - 1;
                } else {
                    l = m;
                }
            }
            if (queries[i] >= items[l][0]) {
                answers[i] = maxs[l];
            } else {
                answers[i] = 0;
            }
        }
        return answers;
    }
}
