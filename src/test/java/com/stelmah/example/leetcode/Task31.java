package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Task31 {

	@Test
	void example1() {
		var nums = new int[] { 1, 2, 3 };
		nextPermutation(nums);
		Assertions.assertArrayEquals(new int[] { 1, 3, 2 }, nums);
	}

	@Test
	void example2() {
		var nums = new int[] { 1, 3, 2 };
		nextPermutation(nums);
		Assertions.assertArrayEquals(new int[] { 2, 1, 3 }, nums);
	}

	@Test
	void example3() {
		var nums = new int[] { 3, 2, 1 };
		nextPermutation(nums);
		Assertions.assertArrayEquals(new int[] { 1, 2, 3 }, nums);
	}

	@Test
	void example4() {
		var nums = new int[] { 1 };
		nextPermutation(nums);
		Assertions.assertArrayEquals(new int[] { 1 }, nums);
	}

	public void nextPermutation(int[] nums) {
		var index = nums.length - 2;
		while (index >= 0) {
			if (nums[index] < nums[index + 1]) {
				break;
			}
			index--;
		}

		var index2 = Math.max(index, 0);
		var current = (index > -1) ? nums[index] : -1;
		var minmax = (index > -1 && index < nums.length) ? nums[index + 1] : Integer.MAX_VALUE;
		var minmaxIndex = index + 1;

		while (index2 < nums.length) {
			if (nums[index2] > current && nums[index2] < minmax) {
				minmax = nums[index2];
				minmaxIndex = index2;
			}
			index2++;
		}
		if (index >= 0) {
			var swap = nums[index];
			nums[index] = nums[minmaxIndex];
			nums[minmaxIndex] = swap;
		}

		Arrays.sort(nums, index +1, nums.length);
	}

}
