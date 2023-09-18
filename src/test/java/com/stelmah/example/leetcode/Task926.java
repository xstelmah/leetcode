package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task926 {

	@Test
	void example1() {
		var s = "00110";
		Assertions.assertEquals(1, minFlipsMonoIncr(s));
	}

	@Test
	void example2() {
		var s = "010110";
		Assertions.assertEquals(2, minFlipsMonoIncr(s));
	}

	@Test
	void example3() {
		var s = "00011000";
		Assertions.assertEquals(2, minFlipsMonoIncr(s));
	}

	@Test
	void example4() {
		var s = "0101100011";
		Assertions.assertEquals(3, minFlipsMonoIncr(s));
	}

	@Test
	void example5() {
		var s = "0111111";
		Assertions.assertEquals(0, minFlipsMonoIncr(s));
	}

	@Test
	void example6() {
		var s = "10011111110010111011";
		Assertions.assertEquals(5, minFlipsMonoIncr(s));
	}

	public int minFlipsMonoIncr(String s) {
		int one = 0;
		int flip = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1')
				one++;
			else
				flip++;
			flip = Math.min(one, flip);
		}
		return flip;
	}

}
