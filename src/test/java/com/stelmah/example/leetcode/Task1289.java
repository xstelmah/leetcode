package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1289 {

	@Test
	void example1() {
		var arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Assertions.assertEquals(13, minFallingPathSum(arr));
	}

	@Test
	void example2() {
		var arr = new int[][] {{-73,61,43,-48,-36},{3,30,27,57,10},{96,-76,84,59,-15},{5,-49,76,31,-7},{97,91,61,-46,67}};
		Assertions.assertEquals(-192, minFallingPathSum(arr));
	}

	public int minFallingPathSum(int[][] grid) {
		for (int i = 1; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				var current = grid[i][j];
				grid[i][j] = Integer.MAX_VALUE;
				for (int z = 0; z < grid.length; z++) {
					if (j == z) continue;
					grid[i][j] = Math.min(grid[i][j], grid[i - 1][z] + current);
				}
			}
		}
		var result = Integer.MAX_VALUE;
		for (int i = 0; i < grid.length; i++) {
			result = Math.min(result, grid[grid.length - 1][i]);
		}
		return result;
	}

}