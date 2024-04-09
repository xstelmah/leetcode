
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


class Task630 {


    @Test
    void example1() {
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        Assertions.assertEquals(3, scheduleCourse(courses));
    }

    @Test
    void example2() {
        int[][] courses = {{100, 200}, {10, 250}, {300, 305}, {2000, 3200}, {5, 255}, {240, 249}};
        Assertions.assertEquals(4, scheduleCourse(courses));
    }

    @Test
    void example3() {
        int[][] courses = {{5, 5}, {4, 6}, {2, 6}};
        Assertions.assertEquals(2, scheduleCourse(courses));
    }

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (o1, o2) -> o1[1] - o2[1]);
        var sum = 0;
        var queue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        var duration = 0;
        var end = 0;
        for (int i = 0; i < courses.length; i++) {
            duration = courses[i][0];
            end = courses[i][1];
            if (sum + duration > end) {
                sum += duration;
                queue.add(duration);
                sum -= queue.poll();
            } else {
                sum += duration;
                queue.add(duration);
            }
        }
        return queue.size();
    }
}
