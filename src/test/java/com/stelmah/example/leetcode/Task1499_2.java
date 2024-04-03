
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task1499_2 {


    @Test
    void example1() {
        int[][] points = {{1, 3}, {2, 0}, {5, 10}, {6, -10}};
        var k = 1;

        Assertions.assertEquals(4, findMaxValueOfEquation(points, k));
    }

    @Test
    void example2() {
        int[][] points = {{-17, -6}, {-4, 0}, {-2, -16}, {-1, 2}, {0, 11}, {6, 18}};
        var k = 13;

        Assertions.assertEquals(35, findMaxValueOfEquation(points, k));
    }

    @Test
    void example3() {
        int[][] points = new int[100_000][2];
        var k = 200000;
        for (int i = 0; i < points.length; i++) {
            points[i][0] = i;
            points[i][1] = i;
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
        var maxIndex = 0;
        var max = 0;
        var answer = Integer.MIN_VALUE;
        var curIndex = 0;
        for (int i = 0; i < points.length - 1; i++) {
            if (i == maxIndex) {
                curIndex = i + 1;
                max = calcMax(points[i + 1]);
                maxIndex = i + 1;
            }
            for (int j = curIndex; j < points.length; j++) {
                var difX = points[j][0] - points[i][0];
                if (difX > k) {
                    break;
                }
                var tempMax = points[j][0] + points[j][1];
                if (tempMax >= max) {
                    max = tempMax;
                    maxIndex = j;
                }
                curIndex = j;
            }
            var difX = points[maxIndex][0] - points[i][0];
            if (difX > k) {
                continue;
            }
            answer = Math.max(answer, calc(points[i], points[maxIndex]));
        }

        return answer;
    }

    public int calc(int[] p1, int[] p2) {
        return p2[0] - p1[0] + p1[1] + p2[1];
    }

    public int calcMax(int[] p) {
        return p[0] + p[1];
    }
}
