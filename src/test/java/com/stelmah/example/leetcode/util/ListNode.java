package com.stelmah.example.leetcode.util;

import java.util.ArrayList;
import java.util.Arrays;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public Integer[] toArray() {
        var list = new ArrayList<Integer>();
        var current = this;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list.toArray(Integer[]::new);
    }

    public static ListNode fromArray(int[] array) {
        var boxedArray = Arrays.stream(array).boxed().toArray(Integer[]::new);

        return fromArray(boxedArray);
    }

    public static ListNode fromArray(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        var root = new ListNode(array[0]);

        var current = root;
        ListNode next = null;
        for (int i = 1; i < array.length; i++) {
            next = new ListNode(array[i]);
            current.next = next;
            current = next;
        }

        return root;
    }

}
