package com.stelmah.example.leetcode;

import com.stelmah.example.leetcode.util.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task155 {

    @Test
    void example1() {
        var root = ListNode.fromArray(new int[]{1, 2, 3, 4});
        var expected = new Integer[]{1, 4, 2, 3};

        Assertions.assertArrayEquals(expected, root.toArray());
    }

    static class MinStack {

        int[][] stack;
        int len;

        public MinStack() {
            stack = new int[30_001][2];
            len = 0;
        }

        public void push(int val) {
            if (len == 0) {
                stack[len++] = new int[] {val, val};
            } else {
                stack[len] = new int[] {val, Math.min(val, stack[len - 1][1])};
                len++;
            }
        }

        public void pop() {
            len--;
        }

        public int top() {
            return stack[len - 1][0];
        }

        public int getMin() {
            return stack[len - 1][1];
        }
    }
}