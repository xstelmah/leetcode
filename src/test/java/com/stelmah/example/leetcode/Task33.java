package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task33 {

	@Test
	void example1() {
		var nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		var target = 0;
		Assertions.assertEquals(4, search(nums, target));
	}

	@Test
	void example2() {
		var nums = new int[] { 4, 5, 6, 7, 8, 0, 1, 2 };
		var target = 0;
		Assertions.assertEquals(5, search(nums, target));
	}

	@Test
	void example3() {
		var nums = new int[] { 4, 5, 6, 7, 8, 9, 10, 0 };
		var target = 0;
		Assertions.assertEquals(7, search(nums, target));
	}

	@Test
	void example4() {
		var nums = new int[] { 4, 5, 6, 7, 8, 9, 10, 0 };
		var target = 4;
		Assertions.assertEquals(0, search(nums, target));
	}

	public int search(int[] nums, int target) {
		var shiftIndex = findShiftIndex(nums);
		var response = -1;
		response = Math.max(response, findShiftIndex(nums, 0, shiftIndex, target));
		if (shiftIndex != nums.length - 1) {
			response = Math.max(response, findShiftIndex(nums, shiftIndex + 1, nums.length - 1, target));
		}
		return response;
	}

	public int findShiftIndex(int[] nums) {
		var left = 0;
		var right = nums.length - 1;
		while (left != right) {
			var middle = (left + right) / 2;
			if (nums[middle] > nums[left]) {
				left = middle;
			} else {
				right = middle;
			}
		}
		return left;
	}

	public int findShiftIndex(int[] nums, int left, int right, int target) {
		while (left != right) {
			var middle = (left + right) / 2;
			if (nums[middle] < target) {
				left = middle + 1;
			} else {
				right = middle;
			}
		}
		if (nums[left] == target) {
			return left;
		}
		if (nums[right] == target) {
			return right;
		}
		return -1;
	}

}
