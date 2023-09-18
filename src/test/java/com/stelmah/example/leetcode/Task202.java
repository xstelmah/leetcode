package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

class Task202 {

	@Test
	void example1() {
		var n = 19;
		Assertions.assertEquals(true, isHappy(n));
	}
	@Test
	void example2() {
		var n = 2;
		Assertions.assertEquals(false, isHappy(n));
	}

	public boolean isHappy(int n) {
		var numbers = new boolean [731];
		var result = 0;
		while (n != 0) {
			result += (n % 10) * (n % 10);
			n = n / 10;
		}
		n = result;
		while (true) {
			if (n == 1) {
				return true;
			}
			if (numbers[n]) {
				return false;
			}
			numbers[n] = true;
			result = 0;
			while (n != 0) {
				result += (n % 10) * (n % 10);
				n = n / 10;
			}
			n = result;
		}
	}

}