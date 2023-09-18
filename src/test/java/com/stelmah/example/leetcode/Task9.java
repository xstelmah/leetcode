package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task9 {

	@Test
	void example1() {
		var s = 121;
		Assertions.assertEquals(true, isPalindrome(s));
	}
	@Test
	void example2() {
		var s = 122;
		Assertions.assertEquals(false, isPalindrome(s));
	}
	@Test
	void example3() {
		var s = -121;
		Assertions.assertEquals(false, isPalindrome(s));
	}

	public boolean isPalindrome(int x) {
		var str = String.valueOf(x);
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

}
