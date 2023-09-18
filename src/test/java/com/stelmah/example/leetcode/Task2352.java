package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class Task2352 {

	@Test
	void example1() {
		var grid = new int[][] { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } };
		Assertions.assertEquals(1, equalPairs(grid));
	}

	@Test
	void example2() {
		var grid = new int[][] { { 3, 1, 2, 2 }, { 1, 4, 4, 5 }, { 2, 4, 2, 2 }, { 2, 4, 2, 2 } };
		Assertions.assertEquals(3, equalPairs(grid));
	}

	public int equalPairs(int[][] grid) {
		var map = new HashMap<Long, Integer>();
		var hash = 0L;
		for (int i = 0; i < grid.length; i++) {
			hash = 0L;
			for (int j = 0; j < grid.length; j++) {
				hash = hash * 230593499 + grid[i][j];
			}
			map.put(hash, map.getOrDefault(hash, 0) + 1);
		}
		var answer = 0;
		for (int i = 0; i < grid.length; i++) {
			hash = 0L;
			for (int j = 0; j < grid.length; j++) {
				hash = hash * 230593499 + grid[j][i];
			}
			answer += map.getOrDefault(hash, 0);
		}

		return answer;
	}

}