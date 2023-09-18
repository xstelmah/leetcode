package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Task45 {

	@Test
	void example1() {
		var nums = new int[] { 2, 3, 1, 1, 4 };
		Assertions.assertEquals(2, jump(nums));
	}

	@Test
	void example2() {
		var nums = new int[] { 1, 1, 1, 1 };
		Assertions.assertEquals(3, jump(nums));
	}

	public int jump(int[] nums) {
		var step = 0;
		var max = 0;
		var nextMax = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			nextMax = Math.max(nextMax, i + nums[i]);
			if (i == max) {
				max = nextMax;
				step++;
			}
		}
		return step;
	}

}
