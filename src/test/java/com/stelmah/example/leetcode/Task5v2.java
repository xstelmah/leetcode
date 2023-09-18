package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task5v2 {

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
		var matrix = new boolean[s.length()][s.length()];
		var answer = "";
		for (int i = 0; i < s.length(); i++) {
			matrix[i][i] = true;
			if (answer.length() == 0) {
				answer = s.substring(i, i + 1);
			}
			if (i + 1 < s.length()) {
				matrix[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
				if (matrix[i][i + 1] && answer.length() < 2) {
					answer = s.substring(i, i + 2);
				}
			}
		}

		for (int length = 2; length < s.length(); length++) {
			for (int j = 0; j + length < s.length(); j++) {
				if (s.charAt(j) == s.charAt(j + length) && matrix[j + 1][j + length - 1]) {
					matrix[j][j + length] = matrix[j + 1][j + length - 1];
					if (answer.length() < length + 1) {
						answer = s.substring(j, j + length + 1);
					}
				}
			}
		}
		return answer;
	}

}
