package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task8 {

	@Test
	void example1() {
		var s = "42";
		Assertions.assertEquals(42, myAtoi(s));
	}

	@Test
	void example2() {
		var s = "   -42";
		Assertions.assertEquals(-42, myAtoi(s));
	}

	@Test
	void example3() {
		var s = "4193 with words";
		Assertions.assertEquals(4193, myAtoi(s));
	}

	@Test
	void example4() {
		var s = "words and 987";
		Assertions.assertEquals(0, myAtoi(s));
	}

	@Test
	void example5() {
		var s = "-91283472332";
		Assertions.assertEquals(-2147483648, myAtoi(s));
	}

	@Test
	void example6() {
		var s = "+1";
		Assertions.assertEquals(1, myAtoi(s));
	}

	@Test
	void example7() {
		var s = "+-12";
		Assertions.assertEquals(0, myAtoi(s));
	}

	@Test
	void example8() {
		var s = "  +  413";
		Assertions.assertEquals(0, myAtoi(s));
	}

	public int myAtoi(String s) {
		var isNegative = false;
		var isNumberSturted = false;
		var isSignMet = false;
		var result = 0;
		for (char chr : s.toCharArray()) {
			if ((chr < '0' || chr > '9') && isNumberSturted) {
				return result;
			} else if ((chr == '-' || chr == '+' || chr == ' ') && isSignMet) {
				return result;
			} else if (chr != '-' && chr != '+' && chr != ' ' && (chr < '0' || chr > '9')) {
				return result;
			}
			if (chr == '-') {
				isNegative = true;
			}
			if (chr == '-' || chr == '+') {
				isSignMet = true;
			}
			if (chr >= '0' && chr <= '9') {
				var newResult = result * 10 + (isNegative ? -(chr - '0') : +(chr - '0'));
				if (newResult / 10 != result) {
					return (isNegative) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				}
				result = newResult;
				isNumberSturted = true;
			}
		}
		return result;
	}

}
