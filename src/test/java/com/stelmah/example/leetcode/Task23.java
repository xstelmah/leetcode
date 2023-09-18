package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Task23 {

	@Test
	void example1() {
		var nums = new int[] { 1, 2, 3 };
	}

	public ListNode mergeKLists(ListNode[] lists) {
		int[] arr = new int[20001];
		for (ListNode list : lists) {
			var current = list;
			while (current != null) {
				arr[current.val + 10000]++;
				current = current.next;
			}
		}
		ListNode response = null;
		ListNode current = null;
		for (int i = 0; i < 20001; i++) {
			for (int j = 0; j < arr[i]; j++) {
				if (current != null) {
					current.next = new ListNode(i - 10000);
					current = current.next;
				} else {
					current = new ListNode(i - 10000);
					response = current;
				}
			}
		}
		return response;
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

	}

}
