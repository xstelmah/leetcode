
package com.stelmah.example.leetcode;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;


class Task430 {

    @Test
    void example1() {
        var node1 = new Node(1, null, new Node(2), new Node(3));
        flatten(node1);
    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        formatAndGetLast(head);
        return head;
    }

    private Node formatAndGetLast(Node node) {
        while (node.child != null || node.next != null) {
            if (node.child != null) {
                var next = node.next;
                var child = node.child;
                node.next = null;
                node.child = null;

                var last = formatAndGetLast(child);

                node.next = child;
                child.prev = node;
                last.next = next;
                if (next != null) {
                    next.prev = last;
                }
            }
            node = node.next;
        }
        return node;
    }


    @AllArgsConstructor
    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }

    }

}
