package com.stelmah.example.leetcode;

import com.stelmah.example.leetcode.util.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task141 {

    @Test
    void example1() {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (head.val == Integer.MIN_VALUE) return true;
        head.val = Integer.MIN_VALUE;
        return hasCycle(head.next);
    }
}