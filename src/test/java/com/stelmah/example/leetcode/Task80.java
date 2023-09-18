package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Task80 {

	@Test
	void example1() {
		var board = new int[] { 1, 1, 1, 2, 2, 3 };
		var expected = new int[] { 1, 1, 2, 2, 3, 3 };

		Assertions.assertEquals(5, removeDuplicates(board));
		Assertions.assertArrayEquals(expected, board);
	}

	@Test
	void example2() {
		var board = new int[] { 1, 1, 1, 2, 2, 2 };
		var q = "abc";
		var q2 = "abc";

		var board2 = new int[8];
		var list = new ArrayList<String >(2000);
		var expected = new int[] { 1, 1, 2, 2, 2, 2 };

		Assertions.assertEquals(4, removeDuplicates(board));
		Assertions.assertArrayEquals(expected, board);
	}

	public int removeDuplicates(int[] nums) {
		var pointer = 0;
		var current = 1;
		while (current < nums.length) {
			if (nums[current] != nums[pointer]) {
				var size = Math.min(2, current - pointer + 1);
				for (int i = 0; i < size; i++) {
					nums[pointer++] = nums[current - 1];
				}
//				if (pointer < nums.length) {
//					nums[pointer] = nums[current];
//				}
			}
			current++;
		}
//		if (pointer == )

		return pointer + 1;
	}

}
