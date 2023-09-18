package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class Task1 {

	@Test
	void twoSumExample1() {
		var array = new int[] { 2, 7, 11, 15 };
		var target = 9;
		var result = twoSum(array, target);
		Assertions.assertEquals(2, result.length);
		var value1 = array[result[0]];
		var value2 = array[result[1]];


		Assertions.assertEquals(target, value1 + value2);
	}

	public int[] twoSum(int[] nums, int target) {
		// 2 <= nums.length <= 10^4
		// -10^9 <= nums[i] <= 10^9
		// -10^9 <= target <= 10^9
		// Only one valid answer exists.

		// solution 1: sort + binary search-> complexity: n*log(n) + n*log(n);
		// solution 2: 2 cycles -> complexity: n^2
		// solution 3: map, hashset -> complexity: 2*n; additional memory: n

		// key - num[i], value - index for this element
		var map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			var remainingAmount = target - nums[i];
			if (map.containsKey(remainingAmount)) {
				return new int[] { i, map.get(remainingAmount) };
			}
			map.put(nums[i], i);
		}
		throw new IllegalStateException("No solution");
	}

}
