package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task1018 {

	@Test
	void example1() {
		var nums = new int[] { 0, 1, 1 };
		var answer = List.of(true, false, false);
		var result = prefixesDivBy5(nums);
		for (int i = 0; i < answer.size(); i++) {
			Assertions.assertEquals(answer.get(i), result.get(i));
		}
	}

	@Test
	void example2() {
		var nums = new int[] { 1, 0, 1 };
		var answer = List.of(false, false, true);
		var result = prefixesDivBy5(nums);
		for (int i = 0; i < answer.size(); i++) {
			Assertions.assertEquals(answer.get(i), result.get(i));
		}
	}

	@Test
	void example3() {
		var nums = new int[] { 0, 0, 1, 0, 1, 1 };
		var answer = List.of(true, true, false, false, true, false);
		var result = prefixesDivBy5(nums);
		for (int i = 0; i < answer.size(); i++) {
			Assertions.assertEquals(answer.get(i), result.get(i));
		}
	}

	@Test
	void example4() {
		var nums = new int[] { 1, 1, 0, 0, 0, 1, 0, 0, 1 };
		var answer = List.of(false, false, false, false, false, false, false, false, false);
		var result = prefixesDivBy5(nums);
		for (int i = 0; i < answer.size(); i++) {
			Assertions.assertEquals(answer.get(i), result.get(i));
		}
	}

	public List<Boolean> prefixesDivBy5(int[] nums) {
		var result = new ArrayList<Boolean>(nums.length);
		var sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = (sum * 2  + nums[i]) % 10;
			if (sum % 5 == 0) {
				result.add(true);
			} else {
				result.add(false);
			}
		}
		return result;
	}

}