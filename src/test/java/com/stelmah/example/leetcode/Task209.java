package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task209 {

	@Test
	void example1() {
		var target = 7;
		var nums = new int[] { 2, 3, 1, 2, 4, 3 };
		Assertions.assertEquals(2, minSubArrayLen(target, nums));
	}

	@Test
	void example2() {
		var target = 11;
		var nums = new int[] { 1, 2, 3, 4, 5 };
		Assertions.assertEquals(3, minSubArrayLen(target, nums));
	}

	public int minSubArrayLen(int target, int[] nums) {
		var left = 0;
		var right = 0;
		var response = Integer.MAX_VALUE;
		var sum = nums[0];
		while (right < nums.length) {
			// 2, 3, 1, 2, 4, 3
			while (sum < target && right + 1 < nums.length)
				sum += nums[++right];

			if (sum >= target) {
				response = Math.min(response, right - left + 1);
			}
			if (right + 1 < nums.length) {
				sum += nums[++right];
			} else {
				right++;
			}
			while (sum - nums[left] >= target) {
				sum -= nums[left++];
			}
			if (sum >= target) {
				response = Math.min(response, Math.min(right, nums.length - 1) - left + 1);
			}
		}
		return (response == Integer.MAX_VALUE) ? 0 : response;
	}

}
