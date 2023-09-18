package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Task18 {

	@Test
	void example1() {
		var nums = new int[] { 1, 0, -1, 0, -2, 2 };
		var target = 0;
		Assertions.assertEquals(4, fourSum(nums, target).size());
	}

	@Test
	void example2() {
		var nums = new int[] { 2,2,2,2,2 };
		var target = 8;
		Assertions.assertEquals(1, fourSum(nums, target));
	}

	@Test
	void example3() {
		var nums = new int[] { -489,-487,-471,-464,-451,-421,-414,-405,-396,-355,-354,-350,-336,-335,-334,-307,-298,-296,-295,-287,-267,-256,-247,-231,-170,-130,-120,-109,-96,-80,-78,-71,-63,-56,-44,-43,-13,2,9,18,31,36,39,43,49,49,50,61,68,73,99,107,112,113,120,121,173,180,185,190,203,210,233,246,258,296,319,340,345,370,371,378,395,418,436,444,447,451,460,485 };
		var target = 2926;
		Assertions.assertEquals(1, fourSum(nums, target));
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		var response = new ArrayList<List<Integer>>();

		rec(4, map, -target, response, new ArrayList<>(), Integer.MIN_VALUE);
		return response;
	}

	public void rec(int step,
			Map<Integer, Integer> nums,
			int target,
			List<List<Integer>> response,
			List<Integer> current,
			int lastMin) {
		if (step > 1) {
			nums.forEach((k, v) -> {
				if (v == 0 || lastMin > k) {
					return;
				}
				current.add(k);
				nums.put(k, v - 1);

				rec(step - 1, nums, target + k, response, current, Math.max(lastMin, k));

				nums.put(k, v);
				current.remove(k);
			});
		}  else if (step == 1) {
			if (lastMin <= -target && nums.getOrDefault(-target, 0) > 0) {
				current.add(-target);
				var sum = 0L;
				var sum2 = 0;
				for(int i = 0; i < current.size(); i++ ) {
					sum += current.get(i);
					sum2 += current.get(i);
				}
				if (sum == ((long) sum2)) {
					response.add(new ArrayList<>(current));
				}

				current.remove((Integer) (-target));
			}
		}

	}

}
