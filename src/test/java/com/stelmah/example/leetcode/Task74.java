package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task74 {

	@Test
	void example1() {
		var matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		var target = 3;
		Assertions.assertEquals(true, searchMatrix(matrix, target));
	}

	@Test
	void example2() {
		var matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		var target = 9;
		Assertions.assertEquals(false, searchMatrix(matrix, target));
	}

	@Test
	void example21() {
		var matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		var target = 10;
		Assertions.assertEquals(true, searchMatrix(matrix, target));
	}

	@Test
	void example3() {
		var matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		var target = 11;
		Assertions.assertEquals(true, searchMatrix(matrix, target));
	}

	@Test
	void example5() {
		var matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		var target = 16;
		Assertions.assertEquals(true, searchMatrix(matrix, target));
	}

	@Test
	void example4() {
		var matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		var target = 20;
		Assertions.assertEquals(true, searchMatrix(matrix, target));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		var row = columnSearch(matrix, target);
		var column = rowSearch(matrix, target, row);
		if (matrix[row][column] == target) {
			return true;
		}
		return false;
	}

	public int columnSearch(int[][] matrix, int target) {
		var left = 0;
		var right = matrix.length - 1;
		while (left < right) {
			var middle = (left + right) / 2;
			if ((matrix[middle][0] <= target && matrix[middle][matrix[middle].length - 1] >= target) || matrix[middle][0] > target) {
				right = middle;
			} else {
				left = middle + 1;
			}
		}
		return left;
	}

	public int rowSearch(int[][] matrix, int target, int row) {
		var left = 0;
		var right = matrix[row].length - 1;
		while (left < right) {
			var middle = (left + right) / 2;
			if (matrix[row][middle] < target) {
				left = middle + 1;
			} else {
				right = middle;
			}
		}
		return left;
	}

}
