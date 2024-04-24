package com.stelmah.example.leetcode;

import com.stelmah.example.leetcode.util.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task86 {

    @Test
    void example1() {
        int[] head = {1, 4, 3, 2, 5, 2};
        var x = 3;
        Integer[] expected = {1, 2, 2, 4, 3, 5};
        var result = partition(ListNode.fromArray(head), x);
        Assertions.assertArrayEquals(expected, result.toArray());
    }

    /** Beats 100% */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode root1 = null;
        ListNode cur1 = null;
        ListNode root2 = null;
        ListNode cur2 = null;

        while (head != null) {
            if (head.val < x) {
                if (cur1 == null) {
                    root1 = new ListNode(head.val);
                    cur1 = root1;
                } else {
                    cur1.next = new ListNode(head.val);
                    cur1 = cur1.next;
                }
            } else {
                if (cur2 == null) {
                    root2 = new ListNode(head.val);
                    cur2 = root2;
                } else {
                    cur2.next = new ListNode(head.val);
                    cur2 = cur2.next;
                }
            }
            head = head.next;
        }

        if (root1 != null) {
            cur1.next = root2;
            return root1;
        }
        return root2;
    }

}
