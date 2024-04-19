package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

class Task84 {
    @Test
    void example1() {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Assertions.assertEquals(10, largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        var stack = new ArrayDeque<Integer>();
        var area = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            if (stack.isEmpty() || heights[stack.peek()] <= h) {
                stack.push(i);
            } else {
                var top = stack.pop();
                if (stack.isEmpty()) {
                    area = Math.max(area, i * (heights[top]));
                } else {
                    area = Math.max(area, (i - stack.peek() -1) * (heights[top]));
                }
                i--;
            }
        }

        return area;
    }
}
