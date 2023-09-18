package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Task1799 {
	public static long steps = 0;

	@Test
	void example1() {
		var nums = new int[] { 3, 4, 6, 8 };
		Assertions.assertEquals(11, maxScore(nums));
	}

	@Test
	void example2() {
		var nums = new int[] { 1, 2, 3, 4, 5, 6 };
		Assertions.assertEquals(14, maxScore(nums));
	}

	@Test
	void example3() {
		var nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
		Assertions.assertEquals(14, maxScore(nums));
	}

	public int maxScore(int[] nums) {
		Map<Long, Integer> gcds = new HashMap<>();
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				gcds.put(i * 10_000_000L + j, gcd(nums[i], nums[j]));
			}
		}

		return maxScoreRec(nums, gcds, 1);
	}

	public int maxScoreRec(int[] nums, Map<Long, Integer> gcds, int depth) {
		var result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				var first = nums[i];
				var second = nums[j];
				if (first != 0 && second != 0) {
					nums[i] = 0;
					nums[j] = 0;

					result = Math.max(result,
							gcds.get(i * 10_000_000L + j) * depth + maxScoreRec(nums, gcds, depth + 1));

					nums[i] = first;
					nums[j] = second;
				}
			}
		}
		return result;
	}

	public int gcd(int first, int second) {
		while (first != 0 && second != 0) {
			if (first > second) {
				first %= second;
			} else {
				second %= first;
			}
		}
		return first + second;
	}

}