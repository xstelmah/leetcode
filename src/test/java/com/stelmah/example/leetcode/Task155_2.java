package com.stelmah.example.leetcode;

import com.stelmah.example.leetcode.util.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task155_2 {

    @Test
    void example1() {
        var root = ListNode.fromArray(new int[]{1, 2, 3, 4});
        var expected = new Integer[]{1, 4, 2, 3};

        Assertions.assertArrayEquals(expected, root.toArray());
    }

    /**
     * Beats 100%.
     */
    static class MinStack {

        Node head;

        public void push(int val) {
            if (head == null) {
                head = new Node(val, val, null);
            } else {
                head = new Node(val, Math.min(val, head.min), head);
            }
        }

        public void pop() {
            head = head.prev;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

        public static class Node {
            int val;
            int min;
            Node prev;

            public Node(int val, int min, Node prev) {
                this.val = val;
                this.min = min;
                this.prev = prev;
            }
        }
    }

}