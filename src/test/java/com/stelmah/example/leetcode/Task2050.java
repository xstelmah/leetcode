
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class Task2050 {


    @Test
    void example1() {
        int n = 5;
        int[][] relations = {{1, 5}, {2, 5}, {3, 5}, {3, 4}, {4, 5}};
        int[] time = {1, 2, 3, 4, 5};
        Assertions.assertEquals(12, minimumTime(n, relations, time));
    }

    @Test
    void example2() {
        int n = 3;
        int[][] relations = {{1, 3}, {2, 3}};
        int[] time = {3, 2, 5};
        Assertions.assertEquals(8, minimumTime(n, relations, time));
    }

    @Test
    void example3() {
        int n = 9;
        int[][] relations = {{2, 7}, {2, 6}, {3, 6}, {4, 6}, {7, 6}, {2, 1}, {3, 1}, {4, 1}, {6, 1}, {7, 1}, {3, 8}, {5, 8}, {7, 8}, {1, 9}, {2, 9}, {6, 9}, {7, 9}};
        int[] time = {9, 5, 9, 5, 8, 7, 7, 8, 4};
        Assertions.assertEquals(32, minimumTime(n, relations, time));
    }


    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] courses = new int[n + 1];
        List<Integer>[] dependencies = new List[n + 1];
        for (int i = 1; i < dependencies.length; i++) {
            dependencies[i] = new ArrayList<>();
        }
        for (int i = 0; i < relations.length; i++) {
            dependencies[relations[i][1]].add(relations[i][0]);
        }

        var max = 0;
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, dfs(i, courses, time, dependencies));
        }

        return max;
    }

    private int dfs(int current, int[] courses, int[] time, List<Integer>[] dependencies) {
        if (courses[current] != 0) {
            return current;
        }
        var val = time[current - 1];
        if (dependencies.length == 0) {
            return courses[current] = val;
        }
        var max = 0;
        for (var dep : dependencies[current]) {
            if (courses[dep] != 0) {
                max = Math.max(max, courses[dep]);
            } else {
                max = Math.max(max, dfs(dep, courses, time, dependencies));
            }
        }
        return courses[current] = val + max;
    }
}
