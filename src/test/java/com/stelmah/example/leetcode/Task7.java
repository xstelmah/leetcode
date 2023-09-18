package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task7 {

	@Test
	void example1() {
		var x = 123;
		Assertions.assertEquals(321, reverse(x));
	}

	@Test
	void example2() {
		var x = -123;
		Assertions.assertEquals(-321, reverse(x));
	}

	@Test
	void example3() {
		var x = 120;
		Assertions.assertEquals(21, reverse(x));
	}

	@Test
	void example4() {
		var x = 1222222222;
		Assertions.assertEquals(0, reverse(x));
	}

	@Test
	void example5() {
		var x = -1222222221;
		Assertions.assertEquals(-1222222221, reverse(x));
	}

	@Test
	void example6() {
		var x = 1534236469;
		Assertions.assertEquals(0, reverse(x));
	}

	public int reverse(int x) {
		var isNegative = x < 0;
		var intMax = Integer.MAX_VALUE / 10;
		var result = 0;
		while (x != 0) {
			var remainder = x % 10;
			x = x / 10;
			if (Math.abs(result) > intMax) {
				return 0;
			}  else if (Math.abs(result) == intMax) {
				var absRemainder = Math.abs(remainder);
				if (isNegative && absRemainder > 8) {
					return 0;
				}
				if (!isNegative && absRemainder > 7) {
					return 0;
				}
			}
			result = result * 10 + remainder;
		} return result;
	}

}
