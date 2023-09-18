package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class Task409 {

	@Test
	void example1() {
		var s = "abccccdd";
		Assertions.assertEquals(7, longestPalindrome(s));
	}
	@Test
	void example2() {
		var s = "a";
		Assertions.assertEquals(1, longestPalindrome(s));
	}

	public int longestPalindrome(String s) {
		var map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		var oddChar = false;
		var result = 0;
		for (var entry : map.entrySet()) {
			if (entry.getValue() % 2 == 0) {
				result += entry.getValue();
			} else {
				result += entry.getValue() - 1;
				oddChar = true;
			}
		}
		if (oddChar) {
			result ++;
		}
		return result;
	}

}
