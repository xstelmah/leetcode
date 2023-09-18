package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task5 {

	@Test
	void example1() {
		var inputStr = "babad";
		Assertions.assertEquals("bab", longestPalindrome(inputStr));
	}

	@Test
	void example2() {
		var inputStr = "cbbd";
		Assertions.assertEquals("bb", longestPalindrome(inputStr));
	}

	@Test
	void example3() {
		var inputStr = "aacabdkacaa";
		Assertions.assertEquals("aca", longestPalindrome(inputStr));
	}

	public String longestPalindrome(String s) {
		var answer = "";
		for (int i = 0; i < s.length(); i++) {
			var tempAnswer = findLongestPalindromeFromCenter(s, i, i);
			if (tempAnswer.length() > answer.length()) {
				answer = tempAnswer;
			}
			if (i + 1 < s.length()) {
				tempAnswer = findLongestPalindromeFromCenter(s, i, i + 1);
				if (tempAnswer.length() > answer.length()) {
					answer = tempAnswer;
				}
			}
		}
		return answer;
	}

	public String findLongestPalindromeFromCenter(String s, int left, int right) {
		var length = s.length();
		Integer validLeft = null;
		Integer validRight = null;
		while (left >= 0 && right < length) {
			if (s.charAt(left) == s.charAt(right)) {
				validLeft = left;
				validRight = right;
			} else {
				break;
			}
			left--;
			right++;
		}
		if (validLeft != null) {
			return s.substring(validLeft, validRight + 1);
		}

		return "";
	}

}
