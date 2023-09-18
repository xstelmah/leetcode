package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task78 {

	@Test
	void example1() {
		var nums = new int[] { 1, 2, 3 };
		var expected = new Integer[][] { {}, { 1 }, { 2 }, { 1, 2 }, { 3 }, { 1, 3 }, { 2, 3 }, { 1, 2, 3 } };
		var response = subsets(nums);
		Assertions.assertEquals(expected.length, response.size());
	}

	public List<List<Integer>> subsets(int[] nums) {
		var result = new ArrayList<List<Integer>>();
		dfs(nums, new ArrayList<>(), 0, result);
		return result;
	}

	public void dfs(int[] nums, List<Integer> prefix, int pos, List<List<Integer>> result) {
		result.add(new ArrayList<>(prefix));
		if (pos == nums.length + 1) {
			return;
		}
		for (int i = pos; i < nums.length; i++) {
			prefix.add(nums[i]);
			dfs(nums, prefix, i + 1, result);
			prefix.remove(prefix.size() - 1);
		}
	}

}
