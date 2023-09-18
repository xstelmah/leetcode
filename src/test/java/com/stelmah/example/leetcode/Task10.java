package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task10 {

	@Test
	void example1() {
		var s = "aa";
		var p = "a";
		Assertions.assertEquals(false, isMatch(s, p));
	}

	@Test
	void example2() {
		var s = "aa";
		var p = "a*";
		Assertions.assertEquals(true, isMatch(s, p));
	}

	@Test
	void example3() {
		var s = "aa";
		var p = ".*";
		Assertions.assertEquals(true, isMatch(s, p));
	}

	@Test
	void example4() {
		var s = "a";
		var p = "ab*";
		Assertions.assertEquals(true, isMatch(s, p));
	}

	@Test
	void example5() {
		var s = "aaba";
		var p = "ab*a*c*a";
		Assertions.assertEquals(false, isMatch(s, p));
	}

	@Test
	void example6() {
		var s = "mississippi";
		var p = "mis*is*ip*.";
		Assertions.assertEquals(true, isMatch(s, p));
	}

	@Test
	void example7() {
		var s = "aaa";
		var p = ".*";
		Assertions.assertEquals(true, isMatch(s, p));
	}

	public boolean isMatch(String s, String p) {
		if (s.isEmpty() && p.isEmpty()) {
			return true;
		}
		var firstCharMatch = false;
		if (s.length() >= 1 && p.length() >= 1) {
			firstCharMatch = (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
		}
		if (s.length() == 1 && p.length() == 1) {
			return firstCharMatch;
		}
		if (p.isEmpty() && !s.isEmpty()) {
			return false;
		}


		if (p.length() >= 2 && p.charAt(1) == '*') {
			return (isMatch(s, p.substring(2))) || (firstCharMatch && s.length() > 0 && isMatch(s.substring(1),
					p));
		} else {
			return firstCharMatch && isMatch(s.substring(1), p.substring(1));
		}
	}

}
