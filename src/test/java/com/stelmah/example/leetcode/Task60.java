package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Task60 {

	@Test
	void example1() {
		var response = getPermutation(3, 3);
		Assertions.assertEquals("213", response);
	}
	@Test
	void example2() {
		var response = getPermutation(3, 2);
		Assertions.assertEquals("132", response);
	}
	@Test
	void example3() {
		var response = getPermutation(4, 9);
		Assertions.assertEquals("2314", response);
	}

	public String getPermutation(int n, int k) {
		return getPermutation(n, k, IntStream.range(1, n + 1).boxed().collect(Collectors.toList()));
	}

	public String getPermutation(int n, int k, List<Integer> nums) {
		if (n == 1) {
			return nums.get(0) + "";
		}
		var fact = factor(n);
		var k2 = (k-1) / (fact / n);
		var number = nums.get(k2);
		nums.remove(k2);
		return number + getPermutation(n - 1, k - k2 * (fact / n), nums);

	}

	public int factor(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factor(n - 1);
	}

}
