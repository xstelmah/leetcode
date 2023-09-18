package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class Task3 {

	@Test
	void addTwoNumbersExample1() {
		var str1 = "cdd";
		Assertions.assertEquals(2, lengthOfLongestSubstring(str1));
	}
	@Test
	void addTwoNumbersExample2() {
		var str1 = "pwwkew";
		Assertions.assertEquals(3, lengthOfLongestSubstring(str1));
	}

	@Test
	void addTwoNumbersExample3() {
		var str1 = "bbbbb";
		Assertions.assertEquals(1, lengthOfLongestSubstring(str1));
	}

	@Test
	void addTwoNumbersExample4() {
		var str1 = "aaapwkpep";
		Assertions.assertEquals(4, lengthOfLongestSubstring(str1));
	}

	@Test
	void addTwoNumbersExample5() {
		var str1 = "abba";
		Assertions.assertEquals(2, lengthOfLongestSubstring(str1));
	}


	@Test
	void addTwoNumbersExample6() {
		var str1 = "tmmzuxt";
		Assertions.assertEquals(5, lengthOfLongestSubstring(str1));
	}

	int lengthOfLongestSubstring(String s) {
		// key = char, value = index of this char
		var map = new HashMap<Character, Integer>();

		var currentStartPos = 1;
		var answer = 0;

		for (int i = 1; i <= s.length(); i++) {
			var currentChar = s.charAt(i - 1);
			if (map.containsKey(currentChar) && map.get(currentChar) >= currentStartPos) {
				var mapCharIndexOrCurrentPos = Math.max(map.get(currentChar), currentStartPos);
				answer = Math.max(answer, i - mapCharIndexOrCurrentPos);
				currentStartPos = mapCharIndexOrCurrentPos + 1;
			} else {
				answer = Math.max(answer, i - currentStartPos + 1);
			}
			map.put(currentChar, i);
		}
		return answer;
	}

}
