package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Task47 {


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

		Arrays.sort(nums, index + 1, nums.length);
	}

}
