package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Task2 {

	@Test
	void addTwoNumbersExample1() {
		var l1 = createRecursively(9, 9, 9, 9, 9, 9, 9);
		var l2 = createRecursively(9, 9, 9, 9);
		var result = addTwoNumbers(l1, l2);
		Assertions.assertEquals("89990001", result.toString());
	}

	@Test
	void addTwoNumbersExample2() {
		var l1 = createRecursively(9);
		var l2 = createRecursively(9);
		var result = addTwoNumbers(l1, l2);
		Assertions.assertEquals("81", result.toString());
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// so, this is the usual BigDecimal summation
		var l1Node = l1; // the current element from the first list
		var l2Node = l2; // the current element from the second list
		int previousOperationRemainder = 0; // when the number is greater than 10 keep the remainder
		ListNode currentNode = new ListNode(); // current element for both lists
		ListNode resultNode = currentNode; // our response

		while (l1Node != null || l2Node != null) { // we must move while there are elements in any of the lists
			int operationAmt = previousOperationRemainder; // If we have a remainder from a previous operation

			if (l1Node != null) {
				operationAmt += l1Node.val;
				l1Node = l1Node.next; // switch to the next element in the list
			}

			if (l2Node != null) {
				operationAmt += l2Node.val;
				l2Node = l2Node.next; // switch to the next element in the list
			}

			if (operationAmt > 9) {
				previousOperationRemainder = 1;
				operationAmt -= 10;
			} else {
				previousOperationRemainder = 0;
			}

			currentNode.val = operationAmt;

			if (l1Node != null || l2Node != null) {
				currentNode.next = new ListNode();
				currentNode = currentNode.next;
			}
		}

		// we could exit the cycle, but we still have a remainder
		if (previousOperationRemainder == 1) { // after adding two numbers, there can be a remainder, example 3+9 > 10, the remainder is 1
			currentNode.val = 1;
		}

		return resultNode;
	}

	ListNode createRecursively(int... values) {
		if (values.length == 0) {
			throw new IllegalStateException("Invalid values array");
		}
		if (values.length == 1) {
			return new ListNode(values[0]);
		}
		var newNode = new ListNode(values[0]);
		var childNode = createRecursively(Arrays.copyOfRange(values, 1, values.length));
		newNode.next = childNode;
		return newNode;
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

		@Override
		public String toString() {
			if (next != null) {
				return val + next.toString();
			} else {
				return String.valueOf(val);
			}
		}

	}

}
