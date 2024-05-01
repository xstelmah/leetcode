package com.stelmah.example.leetcode;

import com.stelmah.example.leetcode.util.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task143 {

    @Test
    void example1() {
        var root = ListNode.fromArray(new int[]{1, 2, 3, 4});
        var expected = new Integer[]{1, 4, 2, 3};

        reorderList(root);

        Assertions.assertArrayEquals(expected, root.toArray());
    }

    @Test
    void example2() {
        var root = ListNode.fromArray(new int[]{1, 2, 3, 4, 5});
        var expected = new Integer[]{1, 5, 2, 4, 3};

        reorderList(root);

        Assertions.assertArrayEquals(expected, root.toArray());
    }

    public void reorderList(ListNode head) {

        var newRoot = new ListNode();
        revert(head, 0, newRoot);


        var size = newRoot.val;
        newRoot = newRoot.next;
        if (size <= 2) {
            return;
        }

        var halfSize = size / 2;
        var c = head;
        var prevC = c;
        ListNode next1 = null;
        ListNode next2 = null;

        while (halfSize-- > 0) {
            // c -> newRoot
            // c -> newRoot -> c.next -> newRoot.next
            next1 = c.next;
            next2 = newRoot.next;
            prevC = c;
            c.next = newRoot;
            c.next.next = next1;

            c = next1;
            newRoot = next2;
        }
        if ((size % 2) == 1) {
            c.next = null;
        } else {
            prevC.next.next = null;
        }
    }

    public ListNode revert(ListNode root, int depth, ListNode newNode) {
        if (root == null) {
            newNode.val = depth;
            return newNode;
        }
        var node = revert(root.next, depth + 1, newNode);
        node.next = new ListNode(root.val);
        return node.next;
    }
}