package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Task986 {

	@Test
	void example1() {
		var firstList = new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
		var secondList = new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
		var response = new int[][] { { 1, 2 }, { 5, 5 }, { 8, 10 }, { 15, 23 }, { 24, 24 }, { 25, 25 } };
		Assertions.assertArrayEquals(response, intervalIntersection(firstList, secondList));
	}

	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		var index1 = 0;
		var index2 = 0;
		var response = new ArrayList<int[]>();
		while (index1 < firstList.length && index2 < secondList.length) {
			var left1 = firstList[index1][0];
			var right1 = firstList[index1][1];

			var left2 = secondList[index2][0];
			var right2 = secondList[index2][1];

			var maxLeft = Math.max(left1, left2);
			var minRight = Math.min(right1, right2);

			if (checkBetween(maxLeft, left1, right1) && checkBetween(maxLeft, left2, right2) && checkBetween(minRight,
					left1, right1) && checkBetween(minRight, left2, right2)) {
				response.add(new int[] {maxLeft, minRight});
			}
			if (right1 == minRight) {
				index1++;
			}
			if (right2 == minRight) {
				index2++;
			}
		}

		return response.toArray(int[][]::new);
	}

	boolean checkBetween(int target, int left, int right) {
		return target >= left && target <= right;
	}

}
