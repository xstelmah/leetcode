package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task11 {

	@Test
	void example1() {
		var height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		Assertions.assertEquals(49, maxArea(height));
	}

	@Test
	void example2() {
		var height = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assertions.assertEquals(20, maxArea(height));
	}

	@Test
	void example3() {
		var height = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Assertions.assertEquals(20, maxArea(height));
	}

	@Test
	void example4() {
		var height = new int[] { 1, 1 };
		Assertions.assertEquals(1, maxArea(height));
	}

	@Test
	void example5() {
		var height = new int[] { 1, 5, 1, 1, 1, 5, 1 };
		Assertions.assertEquals(1, maxArea(height));
	}

	public int maxArea(int[] height) {
		var left = 0;
		var right = height.length - 1;
		var response = 0;
		while (left <= right) {
			var tempResponse = (right - left) * Math.min(height[left], height[right]);
			if (tempResponse > response) {
				response = tempResponse;
			}
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return response;
	}

}
