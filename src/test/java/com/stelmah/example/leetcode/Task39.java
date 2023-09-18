package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Task39 {

	@Test
	void example1() {
		var candidates = new int[] { 2, 3, 6, 7 };
		var target = 7;
		var response  = combinationSum(candidates, target);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
			if (sum + candidates[i] > target) {
				return;
			}
			prefix.add(candidates[i]);
			dfs(candidates, prefix, sum + candidates[i], target, i, response);
			prefix.remove(prefix.size() - 1);
		}
	}

}
