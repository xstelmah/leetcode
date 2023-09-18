package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task2087 {

	@Test
	void example1() {
		var startPos = new int[] { 0, 0 };
		var homePos = new int[] { 0, 0 };
		var rowCosts = new int[] { 5 };
		var colCosts = new int[] { 26 };
		Assertions.assertEquals(0, minCost(startPos, homePos, rowCosts, colCosts));
	}

	@Test
	void example2() {
		var startPos = new int[] { 1, 0 };
		var homePos = new int[] { 2, 3 };
		var rowCosts = new int[] { 5, 4, 3 };
		var colCosts = new int[] { 8, 2, 6, 7 };
		Assertions.assertEquals(18, minCost(startPos, homePos, rowCosts, colCosts));
	}

	public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
		var row = startPos[0];
		var column = startPos[1];
		var endRow = homePos[0];
		var endColumn = homePos[1];
		var answer = 0;
		while (row != endRow || column != endColumn) {
			if (row > endRow) {
				answer += rowCosts[--row];
			} else if (row < endRow) {
				answer += rowCosts[++row];
			}
			if (column > endColumn) {
				answer += colCosts[--column];
			} else if (column < endColumn) {
				answer += colCosts[++column];
			}
		}
		return answer;
	}

}
