package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class Task239 {

	@Test
	void example1() {
		var nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		var k = 3;
		var response = new int[] { 3, 3, 5, 5, 6, 7 };
		Assertions.assertArrayEquals(response, maxSlidingWindow(nums, k));
	}

	@Test
	void example2() {
		var nums = new int[] { 1,-1 };
		var k = 1;
		var response = new int[] { 1, -1 };
		Assertions.assertArrayEquals(response, maxSlidingWindow(nums, k));
	}

	@Test
	void example3() {
		var nums = new int[] { 1,3,1,2,0,5 };
		var k = 3;
		var response = new int[] {3,3,2,5};
		Assertions.assertArrayEquals(response, maxSlidingWindow(nums, k));
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		var response = new int[nums.length - k + 1];
		var responseIndex = 0;
		var dequeue = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			while (!dequeue.isEmpty() && (dequeue.getFirst() <= i - k || nums[dequeue.getFirst()] < nums[i])) {
				dequeue.removeFirst();
			}
			while (!dequeue.isEmpty() && nums[dequeue.getLast()] < nums[i]) {
				dequeue.removeLast();
			}

			dequeue.addLast(i);
			if (i >= k - 1) {
				response[responseIndex++] = nums[dequeue.getFirst()];
			}
		}
		return response;
	}

}