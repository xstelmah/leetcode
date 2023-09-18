package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;

class Task1144 {

	@Test
	void example1() {
		var nums = new int[] { 1, 2, 3 };
		Assertions.assertEquals(2, movesToMakeZigzag(nums));
	}

	@Test
	void example2() {
		var nums = new int[] { 1, 1, 1 };
		Assertions.assertEquals(1, movesToMakeZigzag(nums));
	}

	@Test
	void example3() {
		var nums = new int[] { 1, 1, 1, 1 };
		Assertions.assertEquals(2, movesToMakeZigzag(nums));
	}

	@Test
	void example4() {
		var nums = new int[] { 9,6,1,6,2 };
		Assertions.assertEquals(4, movesToMakeZigzag(nums));
	}

	@Test
	void example5() {
		var nums = new int[] { 1 };
		Assertions.assertEquals(0, movesToMakeZigzag(nums));
	}

	public int movesToMakeZigzag(int[] nums) {
		var startDirections = new int[] { 1, -1 };
		var answer = Integer.MAX_VALUE;
		for (var startDirection : startDirections) {
			var currentDirection = startDirection;
			var tempAnswer = 0;
			var previous = (Integer) null;
			var current = nums[0];
			var next = nums.length > 1 ? nums[1] : null;
			var index = 1;
			while (next != null) {
				if (currentDirection > 0) {
					if (previous != null && previous >= current) {
						tempAnswer += previous - current + 1;
					}
					if (next >= current) {
						tempAnswer += next - current + 1;
						next = current - 1;
					}
				} else {
					if (previous != null && previous <= current) {
						tempAnswer += current - previous + 1;
					}
					if (next <= current) {
						tempAnswer += current - next + 1;
						current = next - 1;
					}
				}

				currentDirection = -currentDirection;
				previous = current;
				current = next;
				if (++index < nums.length) {
					next = nums[index];
				} else {
					next = null;
				}
			}
			answer = Math.min(answer, tempAnswer);
		}
		return answer;
	}

}
