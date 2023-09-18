package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class Task29 {

	@Test
	void example1() {
		var dividend = 10;
		var divisor = 3;
		Assertions.assertEquals(3, divide(dividend, divisor));
	}

	@Test
	void example2() {
		var dividend = 12;
		var divisor = 3;
		Assertions.assertEquals(4, divide(dividend, divisor));
	}

	@Test
	void example3() {
		var dividend = Integer.MAX_VALUE;
		var divisor = 3;
		Assertions.assertEquals(715827882, divide(dividend, divisor));
	}

	@Test
	void example4() {
		var dividend = 1;
		var divisor = 3;
		Assertions.assertEquals(0, divide(dividend, divisor));
	}

	@Test
	void example5() {
		var dividend = -11;
		var divisor = 3;
		Assertions.assertEquals(-3, divide(dividend, divisor));
	}

	@Test
	void example6() {
		var dividend = Integer.MIN_VALUE;
		var divisor = -2;
		Assertions.assertEquals(1073741824, divide(dividend, divisor));
	}

	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		var isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
		long dividend2 = Math.abs((long)dividend);
		long divisor2 = Math.abs((long)divisor);
		var tempDivisor = divisor2;
		var answer = 0;
		var coeff = 1;
		while (dividend2 >= divisor2) {
			if (tempDivisor << 1 >> 1 == tempDivisor && tempDivisor << 1 <= dividend2) {
				tempDivisor <<= 1;
				coeff <<= 1;
			} else {
				if (dividend2 - tempDivisor >= 0) {
					answer += coeff;
					dividend2 -= tempDivisor;
				} else {
					coeff >>= 1;
					tempDivisor >>= 1;
				}
			}
		}
		return (isNegative) ? -answer : answer;
	}

}
