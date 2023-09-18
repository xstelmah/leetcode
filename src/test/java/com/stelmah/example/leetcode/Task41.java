package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task41 {

	@Test
	void example1() {
		var nums = new int[] { 3, 4, -1, 1 };
		Assertions.assertEquals(2, firstMissingPositive(nums));
	}

	@Test
	void example2() {
		var nums = new int[] {3 };
		Assertions.assertEquals(1, firstMissingPositive(nums));
	}

	@Test
	void example3() {
		var nums = new int[] {7,8,9,11,12};
		Assertions.assertEquals(1, firstMissingPositive(nums));
	}

	public int firstMissingPositive(int[] nums) {
		var existing = new boolean[500_003];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0 && nums[i] <= 500_001) {
				existing[nums[i]] = true;
			}
		}
		for (int i = 1; i < 500_003; i++) {
			if (!existing[i]) {
				return i;
			}
		}
		return -1;
	}

}
