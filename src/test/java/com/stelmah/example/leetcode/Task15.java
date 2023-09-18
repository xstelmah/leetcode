package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Task15 {

	@Test
	void example1() {
		var num = new int[] { -1, 0, 1, 2, -1, -4, 6, -8, 2, 0, 0 };

		System.out.println(threeSum(num));
		Assertions.assertEquals(2, threeSum(num).size());
	}

	public List<List<Integer>> threeSum(int[] nums) {
		var result = new LinkedList<List<Integer>>();
		var positiveMap = new HashMap<Integer, Integer>();
		var negativeMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				negativeMap.put(nums[i], negativeMap.getOrDefault(nums[i], 0) + 1);
			} else {
				positiveMap.put(nums[i], positiveMap.getOrDefault(nums[i], 0) + 1);
			}
		}
		if (positiveMap.getOrDefault(0, 0) > 2) {
			result.add(List.of(0, 0, 0));
		}
		if (positiveMap.containsKey(0)) {
			negativeMap.forEach((k, v) -> {
				if (positiveMap.containsKey(-k)) {
					result.add(List.of(k, 0, -k));
				}
			});
		}
		negativeMap.forEach((k1, v1) -> {
			positiveMap.forEach((k2, v2) -> {
				if (k2 != 0) {
					if (!k2.equals(-k1) && positiveMap.containsKey(-(k1 + k2)) && k2 <= -(k1 + k2)) {
						if (k1 != -k2 * 2 || (k1 == -k2 * 2 && positiveMap.getOrDefault(k2, 0) > 1)) {
							result.add(List.of(k1, k2, -(k1 + k2)));
						}
					}
				}
			});
		});
		positiveMap.forEach((k1, v1) -> {
			negativeMap.forEach((k2, v2) -> {
				if (k2 != 0) {
					if (!k2.equals(-k1) && negativeMap.containsKey(-(k1 + k2)) && k2 <= -(k1 + k2)) {
						if (k1 != -k2 * 2 || (k1 == -k2 * 2 && negativeMap.getOrDefault(k2, 0) > 1)) {
							result.add(List.of(k1, k2, -(k1 + k2)));
						}
					}
				}
			});
		});
		return result;
	}

}
