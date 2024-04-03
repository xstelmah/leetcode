
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;


class Task1499 {


    @Test
    void example1() {
        int[][] points = {{1, 3}, {2, 0}, {5, 10}, {6, -10}};
        var k = 1;

        Assertions.assertEquals(4, findMaxValueOfEquation(points, k));
    }
    @Test
    void example2() {
        int[][] points = {{-17,-6},{-4,0},{-2,-16},{-1,2},{0,11},{6,18}};
        var k = 13;

        Assertions.assertEquals(35, findMaxValueOfEquation(points, k));
    }
    @Test
    void example3() {
        int[][] points = new int[100_000][2];
        var k = 200000;
        for (int i = 0; i< points.length; i++) {
            points[i][0]= i;
            points[i][1]= i;
        }

        Assertions.assertEquals(199_998, findMaxValueOfEquation(points, k));
    }

    @Test
    void example4() {
        int[][] points = new int[100_000][2];
        var k = 100000;
        for (int i = 0; i < points.length; i++) {
            points[i][0] = i;
            points[i][1] = 0;
        }

        Assertions.assertEquals(99_999, findMaxValueOfEquation(points, k));
    }

    public int findMaxValueOfEquation(int[][] points, int k) {
        for (int i = 0; i < points.length; i++) {
            points[i][0] += 100_000_000;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(p -> -(p[0] + p[1])));
        var l = 0;
        var r = 0;
        var answer = Integer.MIN_VALUE;
        while (r <= points.length && l < points.length) {
            while (r < points.length && points[r][0] - points[l][0] <= k) {
                queue.add(points[r]);
                r++;
            }
            while (!queue.isEmpty() && queue.peek()[0] <= points[l][0]) queue.poll();
            if (!queue.isEmpty()) {
                var top = queue.peek();
                answer = Math.max(answer, points[l][1] + top[1] + top[0] - points[l][0]);
            }
            l++;
            if (r < l) {
                r = l;
            }
        }
        return answer;
    }
}
