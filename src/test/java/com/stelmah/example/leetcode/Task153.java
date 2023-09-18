package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task153 {

	@Test
	void example1() {
		var nums = new int[] { 3, 4, 5, 1, 2 };
		Assertions.assertEquals(1, findMin(nums));
	}

	@Test
	void example2() {
		var nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		Assertions.assertEquals(0, findMin(nums));
	}

	@Test
	void example3() {
		var nums = new int[] { 11, 13, 15, 17 };
		Assertions.assertEquals(11, findMin(nums));
	}

	public int findMin(int[] nums) {
		var shiftIndex = findShiftIndex(nums);
		return nums[(shiftIndex + 1) % nums.length];
	}

	public int findShiftIndex(int[] nums) {
		var left = 0;
		var right = nums.length - 1;
		while (right - left > 1) {
			var middle = (left + right) / 2;
			if (nums[left] < nums[middle]) {
				left = middle;
			} else {
				right = middle;
			}
		}
		return (nums[left] > nums[right]) ? left : right;
	}

}
