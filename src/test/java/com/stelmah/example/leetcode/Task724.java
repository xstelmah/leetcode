package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task724 {

	@Test
	void example1() {
		var nums = new int[] { 1, 7, 3, 6, 5, 6 };
		Assertions.assertEquals(3, pivotIndex(nums));
	}

	public int pivotIndex(int[] nums) {
		var left = 0;
		var right = 0;
		for (int i = 0; i < nums.length; i++) {
			right += nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			if (i > 0) {
				left += nums[i - 1];
			}
			right -= nums[i];
			if (left == right) {
				return i;
			}
		}
		return -1;
	}

}
