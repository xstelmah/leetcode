package com.stelmah.example.leetcode;

import com.stelmah.example.leetcode.util.ListNode;
import org.junit.jupiter.api.Test;

class Task142 {

    @Test
    void example1() {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        if (head.val == Integer.MIN_VALUE) return head;
        head.val = Integer.MIN_VALUE;
        return detectCycle(head.next);
    }
}