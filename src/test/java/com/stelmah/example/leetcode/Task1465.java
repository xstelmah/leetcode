package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Task1465 {

	@Test
	void example1() {
		var h = 5;
		var w = 4;
		var horizontalCuts = new int[] { 3, 1 };
		var verticalCuts = new int[] { 1 };
		Assertions.assertEquals(6, maxArea(h, w, horizontalCuts, verticalCuts));
	}

	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		var current = 0;
		var next = 0;
		var maxH = 0;
		for (int i = 0; i < horizontalCuts.length; i++) {
			next = horizontalCuts[i];
			maxH = Math.max(maxH, next - current);
			current = next;
		}
		maxH = Math.max(maxH, h - current);
		var maxV = 0;
		current = 0;
		next = 0;
		for (int i = 0; i < verticalCuts.length; i++) {
			next = verticalCuts[i];
			maxV = Math.max(maxV, next - current);
			current = next;
		}
		maxV = Math.max(maxV, w - current);
		return (int)((((long)maxH) * maxV) % 1_000_000_007);
	}

}
