package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Task24 {

	@Test
	void example1() {
		var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
		var result = swapPairs(head);
		var expected = new int[] {2,1,4,3};
		for (int i = 0; i<4; i++) {
			Assertions.assertEquals(expected[i], result.val);
			result = result.next;
		}
	}

	public ListNode swapPairs(ListNode head, ListNode prev) {
		if (head == null) {
			return null;
		}
		if (head.next != null) {
			var curr = head;
			var next = head.next;
			curr.next = next.next;
			next.next = curr;
			if (prev != null) {
				prev.next = next;
			}
			swapPairs(curr.next, curr);
			return next;
		}
		return head;
	}

	public ListNode swapPairs(ListNode head) {
		return swapPairs(head, null);
	}

	public class ListNode {
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

		@Override
		public String toString() {
			return "ListNode{" + "val=" + val + '}';
		}

	}

}
