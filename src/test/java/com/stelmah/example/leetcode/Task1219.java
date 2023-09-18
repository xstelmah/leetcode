package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1219 {

	@Test
	void example1() {
		var arr = new int[][] { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } };
		Assertions.assertEquals(24, getMaximumGold(arr));
	}

	@Test
	void example2() {
		var arr = new int[][] {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
		Assertions.assertEquals(28, getMaximumGold(arr));
	}

	int[] dx = new int[] { 0, 0, 1, -1 };
	int[] dy = new int[] { 1, -1, 0, 0 };

	public int getMaximumGold(int[][] grid) {
		var response = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				response = Math.max(response, getMaxGoldRec(grid, new boolean[grid.length][grid[0].length], i, j, 0));
			}
		}
		return response;
	}

	public int getMaxGoldRec(int[][] grid, boolean[][] history, int x, int y, int sum) {
		if (grid[x][y] == 0) {
			return sum;
		}
		if (history[x][y]) {
			return sum;
		}
		history[x][y] = true;
		var tempAns = sum;
		for (int i = 0; i < 4; i++) {
			var newX = x + dx[i];
			var newY = y + dy[i];
			if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
				tempAns = Math.max(tempAns, getMaxGoldRec(grid, history, newX, newY, sum + grid[x][y]));
			}
		}
		history[x][y] = false;
		return tempAns;
	}

}