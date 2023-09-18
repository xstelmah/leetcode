package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class Task2312 {

	@Test
	void example1() {
		var m = 3;
		var n = 5;
		var prices = new int[][] { { 1, 4, 2 }, { 2, 2, 7 }, { 2, 1, 3 } };
		Assertions.assertEquals(19, sellingWood(m, n, prices));
	}

	@Test
	void example2() {
		var m = 4;
		var n = 6;
		var prices = new int[][] { { 3, 2, 10 }, { 1, 4, 2 }, { 4, 1, 3 } };
		Assertions.assertEquals(32, sellingWood(m, n, prices));
	}

	public long sellingWood(int rows, int columns, int[][] prices) {
		var dp = new long[rows + 1][columns + 1];
		for (var price : prices) {
			dp[price[0]][price[1]] = price[2];
		}
		for (int row = 1; row <= rows; row++) {
			for (int column = 1; column <= columns; column++) {
				for (int x = 1; x <= column / 2; x++) {
					dp[row][column] = Math.max(dp[row][column], dp[row][column - x] + dp[row][x]);
				}
				for (int y = 1; y <= row / 2; y++) {
					dp[row][column] = Math.max(dp[row][column], dp[row - y][column] + dp[y][column]);
				}
			}
		}
		return dp[rows][columns];
	}

	public long sellingWood_not_working(int rows, int columns, int[][] prices) {
		var dp = new long[rows + 1][columns + 1];
		for (int row = 1; row <= rows; row++) {
			for (int column = 1; column <= columns; column++) {
				for (var price : prices) {
					var y = price[0];
					var x = price[1];
					var cost = price[2];
					if (row - y >= 0 && column - x >= 0) {
						dp[row][column] = Math.max(dp[row][column], Math.max(dp[row][column - x] + dp[row - y][x],
								dp[row - y][column] + dp[y][column - x]) + cost);
					}
				}
			}
		}
		return dp[rows][columns];
	}

}