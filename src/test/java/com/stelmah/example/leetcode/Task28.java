package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task28 {

	@Test
	void example1() {
		var haystack = "sadbutsad";
		var needle = "sad";
		Assertions.assertEquals(0, strStr(haystack, needle));
	}
	@Test
	void example2() {
		var haystack = "sabbutsad";
		var needle = "sad";
		Assertions.assertEquals(6, strStr(haystack, needle));
	}

	public int strStr(String haystack, String needle) {
		for (int i = 0; i < haystack.length(); i++) {
			for (int j = 0; j < needle.length(); j++) {
				if (i + j >= haystack.length())
					break;
				if (haystack.charAt(i + j) != needle.charAt(j))
					break;
				if (j == needle.length() - 1)
					return i;
			}
		}
		return -1;
	}

}
