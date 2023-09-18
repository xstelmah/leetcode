package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task713 {

	@Test
	void example1() {
		var nums = new int[] { 10, 5, 2, 6 };
		var k = 100;
		Assertions.assertEquals(8, numSubarrayProductLessThanK(nums, k));
	}

	@Test
	void example2() {
		var nums = new int[] { 1, 2, 3 };
		var k = 0;
		Assertions.assertEquals(0, numSubarrayProductLessThanK(nums, k));
	}

	@Test
	void example3() {
		var nums = new int[] {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
		var k = 19;
		Assertions.assertEquals(18, numSubarrayProductLessThanK(nums, k));
	}

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		var left = 0;
		var right = 0;
		var response = 0;
		var count = 1;
		var power = nums[left];
		while (left < nums.length) {
			while (right + 1 < nums.length && nums[right + 1] * power < k) {
				power *= nums[++right];
				count++;
			}
			response += (power < k) ? count : 0;

			power /= nums[left];
			count = Math.max(1, count - 1);
			left++;
			right = Math.max(left, right);
			if (left == right && left < nums.length) {
				power = nums[left];
			}
		}
		return response;
	}

}
