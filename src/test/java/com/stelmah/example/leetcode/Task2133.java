package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class Task2133 {

	@Test
	void example2() {
		var board = new int[][] { { 1, 1, 1 }, { 1, 2, 3 }, { 1, 2, 3 } };

		Assertions.assertEquals(false, checkValid(board));
	}

	public boolean checkValid(int[][] matrix) {
		var set = new HashSet<Integer>();
		var row = 0;
		var column = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				row = 100_000 + i * 101 + matrix[i][j];
				column = 200_000 + j * 101 + matrix[i][j];
				if (set.contains(row) || set.contains(column)) {
					return false;
				} else {
					set.add(row);
					set.add(column);
				}
			}
		}
		return true;
	}

}
