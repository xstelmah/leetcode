package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task162 {

	@Test
	void example1() {
		var nums = new int[] { 1, 2, 1, 3, 5, 6, 4 };
		Assertions.assertEquals(5, findPeakElement(nums));
	}

	public int findPeakElement(int[] nums) {
		short left = 0;
		short right = (short) (nums.length - 1);
		short middle = 0;
		while (left < right) {
			middle = (short) ((left + right) / 2);
			if (nums[middle] < nums[middle + 1]) {
				left = (short) (middle + 1);
			} else {
				right = middle;
			}
		}
		return left;
	}

}
