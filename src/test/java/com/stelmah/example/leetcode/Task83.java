package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task83 {

	@Test
	void example1() {
		var nums = new ListNode(1,
				new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
		var resp = new int[] { 1, 2, 5 };
		var listNode = deleteDuplicates(nums);
		for (int i = 0; i < resp.length; i++) {
			Assertions.assertEquals(resp[i], listNode.val);
			listNode = listNode.next;
		}
	}

	@Test
	void example2() {
		var nums = new ListNode(1,
				new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3))))));
		var resp = new int[] { 2, 3 };
		var listNode = deleteDuplicates(nums);
		for (int i = 0; i < resp.length; i++) {
			Assertions.assertEquals(resp[i], listNode.val);
			listNode = listNode.next;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		var first = (ListNode) null;
		var current = head;
		var previous = (ListNode) null;
		while (current != null) {
			var removable = current.next != null && current.val == current.next.val;
			if (!removable && first == null) {
				first = current;
			}
			var next = current.next;
			while (next != null && current.val == next.val) {
				next = next.next;
			}

			if (!removable) {
				previous = current;
			}
			current = next;
			if (previous != null) {
				previous.next = current;
			}
		}
		return first;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

	}

}
