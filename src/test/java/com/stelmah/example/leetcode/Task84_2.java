package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

class Task84_2 {
    @Test
    void example1() {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Assertions.assertEquals(10, largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        var stack = new int[heights.length + 1];
        var stackPos = -1;
        var area = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            if (stackPos == -1 || heights[stack[stackPos]] <= h) {
                stack[++stackPos] = i;
            } else {
                var top = stack[stackPos--];
                if (stackPos == -1) {
                    area = Math.max(area, i * (heights[top]));
                } else {
                    area = Math.max(area, (i - stack[stackPos] - 1) * (heights[top]));
                }
                i--;
            }
        }

        return area;
    }
}
