package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Task34 {

	@Test
	void example1() {
		var nums = new int[] { 5, 7, 7, 8, 8, 10 };
		var target = 8;
		var expected = new int[] { 3, 4 };
		Assertions.assertArrayEquals(expected, searchRange(nums, target));
	}

	@Test
	void example2() {
		var nums = new int[] { 1, 4 };
		var target = 4;
		var expected = new int[] { 1, 1 };
		Assertions.assertArrayEquals(expected, searchRange(nums, target));
	}

	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[] { -1, -1 };
		}
		var leftIndex = -1;
		var left = 0;
		var right = nums.length - 1;
		while (left < right) {
			var middle = (left + right) / 2;
			if (nums[middle] >= target) {
				right = middle;
			} else {
				left = middle + 1;
			}
		}
		if (nums[left] != target) {
			return new int[] { -1, -1 };
		}
		leftIndex = left;
		left = 0;
		right = nums.length - 1;
		while (right - left > 1) {
			var middle = (left + right) / 2;
			if (nums[middle] > target) {
				right = middle;
			} else {
				left = middle;
			}
		}
		if (nums[left] != target && nums[right] != target) {
			return new int[] { -1, -1 };
		}
		return new int[] { leftIndex, nums[right] == target? right : left };
	}

}
