package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Task40 {

	@Test
	void example1() {
		var candidates = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		var target = 8;
		var response = combinationSum2(candidates, target);
		Assertions.assertEquals(4, response.size());
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		var response = new ArrayList<List<Integer>>();
		dfs(candidates, new ArrayList<>(), 0, target, 0, response);

		return response;
	}

	public void dfs(int[] candidates,
			List<Integer> prefix,
			int sum,
			int target,
			int pos,
			List<List<Integer>> response) {
		if (sum == target) {
			response.add(new ArrayList<>(prefix));
		}
		if (sum > target) {
			return;
		}
		for (int i = pos; i < candidates.length; i++) {
			while (i != pos && i < candidates.length && candidates[i] == candidates[i - 1])
				i++;
			if (i >= candidates.length) {
				return;
			}
			if (sum + candidates[i] > target) {
				return;
			}
			prefix.add(candidates[i]);
			dfs(candidates, prefix, sum + candidates[i], target, i + 1, response);
			prefix.remove(prefix.size() - 1);
		}
	}

}
