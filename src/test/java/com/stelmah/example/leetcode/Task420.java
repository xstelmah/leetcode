package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task420 {

	@Test
	void example1() {
		var password = "a";
		Assertions.assertEquals(5, strongPasswordChecker(password));
	}

	@Test
	void example2() {
		var password = "aA1";
		Assertions.assertEquals(3, strongPasswordChecker(password));
	}

	@Test
	void example3() {
		var password = "1337C0d3";
		Assertions.assertEquals(0, strongPasswordChecker(password));
	}

	@Test
	void example4() {
		var password = "ABABABABABABABABABAB1";
		Assertions.assertEquals(2, strongPasswordChecker(password));
	}

	@Test
	void example5() {
		var password = "bbaaaaaaaaaaaaaaacccccc";
		Assertions.assertEquals(8, strongPasswordChecker(password));
	}

	public int strongPasswordChecker(String password) {
		var charCountArray = new int[password.length()];
		var lastChar = '$';
		var lastCharPos = 0;
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) != lastChar) {
				lastChar = password.charAt(i);
				lastCharPos = i;
			}
			charCountArray[lastCharPos]++;
		}
		var lengthError = 6 - Math.min(password.length(), 6);
		var containsLowerCase = password.matches(".*?[a-z].*?");
		var containsUpperCase = password.matches(".*?[A-Z].*?");
		var containsDigit = password.matches(".*?\\d.*?");
		var containsRequired = ((!containsLowerCase) ? 1 : 0) + ((!containsUpperCase) ? 1 : 0) + ((!containsDigit) ?
				1 :
				0);
		var newChars = Math.max(lengthError, containsRequired);
		var removeRequired = Math.max(password.length() - 20, 0);
		var answer = removeRequired;

		for (int k = 1; k <= 3; k++) {
			for (int i = 0; i < password.length(); i++) {
				if (removeRequired < k)
					break;
				if (charCountArray[i] >= 3 && (charCountArray[i] + 1 - k) % 3 == 0) {
					removeRequired -= k;
					charCountArray[i] -= k;
				}
			}
		}
		for (int k = 3; k >= 1; k--) {
			for (int i = 0; i < password.length(); i++) {
				if (removeRequired == 0)
					break;
				while (removeRequired >= k && charCountArray[i] >= k) {
					removeRequired -= k;
					charCountArray[i] -= k;
				}
			}
		}

		for (int i = 0; i < password.length(); i++) {
			if (charCountArray[i] >= 3) {
				var tempAns = charCountArray[i] / 3;
				newChars = Math.max(0, newChars - tempAns);
				answer += tempAns;
			}
		}
		answer += newChars;

		return answer;
	}

}
