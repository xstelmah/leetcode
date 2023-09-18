package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Task16 {

	@Test
	void example1() {
		var nums = new int[] { -1, 2, 1, -4 };
		var target = 1;
		Assertions.assertEquals(2, threeSumClosest(nums, target));
	}
	@Test
	void example2() {
		var nums = new int[] { 0, 0, 0 };
		var target = 1;
		Assertions.assertEquals(0, threeSumClosest(nums, target));
	}
	@Test
	void example3() {
		var nums = new int[] { 1, -1, 6, 4, 1, 5};
		var target = 5;
		Assertions.assertEquals(5, threeSumClosest(nums, target));
	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		var result = 100000;
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				var expected = target - (nums[i] + nums[j]);
				var left = j + 1;
				var right = nums.length - 1;
				while (left != right) {
					var medium = (left + right) / 2;
					if (nums[medium] >= expected) {
						right = medium;
					} else {
						left = medium + 1;
					}
				}
				if (Math.abs(target - result) > Math.abs(target - (nums[i] + nums[j] + nums[left]))) {
					result = nums[i] + nums[j] + nums[left];
				}
			}
		}
		return result;
	}

}