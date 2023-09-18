package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Task50 {

	@Test
	void example1() {
		var x = 2.00000D;
		var n = 10;
		Assertions.assertEquals(1024, myPow(2, 10));
	}

	@Test
	void example2() {
		Assertions.assertEquals(1, myPow(1, 	-2147483648));
	}

	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 1.0D / (x * myPow(x, -(n + 1)));
		}
		if (n % 2 == 0) {
			return myPow(x * x, n / 2);
		} else {
			return x * myPow(x, n - 1);
		}
	}

}
