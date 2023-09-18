package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

class Task32 {

	@Test
	void example1() {
		var s = ")()())";
		Assertions.assertEquals(4, longestValidParentheses(s));
	}

	@Test
	void example2() {
		var s = ")(()())))()()()(())";
		Assertions.assertEquals(10, longestValidParentheses(s));
	}

	@Test
	void example3() {
		var s = "()(()";
		Assertions.assertEquals(2, longestValidParentheses(s));
	}

	@Test
	void example4() {
		var s = "()(((())";
		Assertions.assertEquals(4, longestValidParentheses(s));
	}

	public int longestValidParentheses(String s) {
		if (s.length() == 0) {
			return 0;
		}
		var max = 0;
		var stack = new LinkedList<Integer>();
		var dp = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty()) {
					var pos = stack.pollFirst();
					dp[i] = (i - 1 >= 0 ? dp[i - 1] : 0) + 2 + (pos - 1 >= 0 ? dp[pos - 1] : 0);
					max = Math.max(max, dp[i]);
				}
			}
		}
		return max;
	}

}
