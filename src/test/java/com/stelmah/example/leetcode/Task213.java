package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Task213 {

	@Test
	void example1() {
		var nums = new int[] { 2, 3, 2 };
		Assertions.assertEquals(3, rob(nums));
	}

	@Test
	void example2() {
		var nums = new int[] { 2, 4 };
		Assertions.assertEquals(4, rob(nums));
	}

	@Test
	void example3() {
		var nums = new int[] { 5 };
		Assertions.assertEquals(5, rob(nums));
	}

	@Test
	void example4() {
		var nums = new int[] { 200, 3, 140, 20, 10 };
		Assertions.assertEquals(340, rob(nums));
	}

	@Test
	void example5() {
		var nums = new int[] { 1, 2, 1, 1 };
		Assertions.assertEquals(3, rob(nums));
	}

	public int rob(int[] nums) {
		if (nums.length < 4) {
			return Arrays.stream(nums).max().getAsInt();
		}
		var isFirstTaken = false;
		var dp = new int[nums.length];
		for (int i = 0; i < dp.length; i++) {
			var left = (i == dp.length - 1 && isFirstTaken ? 0 : nums[i]) + (i - 2 >= 0 ? dp[i - 2] : 0);
			var right = (i - 1 >= 0 ? dp[i - 1] : 0);
			if (right > left) {
				isFirstTaken = false;
			}
			if (i == 0 && left > right) {
				isFirstTaken = true;
			}
			dp[i] = Math.max(left, right);
		}
		return dp[nums.length - 1];
	}

}
