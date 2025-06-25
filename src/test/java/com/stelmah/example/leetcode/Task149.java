package com.stelmah.example.leetcode;

import com.stelmah.example.leetcode.util.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class Task149 {

    @Test
    void example1() {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};

        Assertions.assertEquals(3, maxPoints(points));
    }
    @Test
    void example2() {
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};

        Assertions.assertEquals(4, maxPoints(points));
    }

    public int maxPoints(int[][] points) {
        var answer = 1;
        for (int i = 0; i < points.length; i++) {
            var currentX = points[i][0];
            var currentY = points[i][1];

            var map = new HashMap<Long, Integer>();

//            var temp = 1;
            for (int j = i + 1; j < points.length; j++) {
                var targetX = points[j][0] - currentX;
                var targetY = points[j][1] - currentY;
                var gcd = gcd(targetX, targetY);
                targetX = targetX / gcd;
                targetY = targetY / gcd;

                map.put(targetX * 100_000L + targetY, map.getOrDefault(targetX * 100_000L + targetY, 0) + 1);
                map.put(targetX * -100_000L - targetY, map.getOrDefault(targetX * -100_000L - targetY, 0) + 1);
            }
            var max = 0;
            for (Integer value : map.values()) {
                max = Math.max(max, value);
            }

            answer = Math.max(answer, 1 + max);
        }
        return answer;
    }

    int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return a+b;
    }
}