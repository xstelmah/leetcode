package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Task20 {

	@Test
	void example1() {
		var s = "()[]{}";
		Assertions.assertTrue(isValid(s));
	}
	@Test
	void example2() {
		var s = "()[}{}";
		Assertions.assertFalse(isValid(s));
	}

	public boolean isValid(String s) {
		var stack = new LinkedList<>();

		var openBrackets = List.of('(', '{', '[');
		var closeBrackets = List.of(')', '}', ']');
		for (var chr : s.toCharArray()) {
			if (openBrackets.contains(chr)) {
				var indexOfOpenChar = openBrackets.indexOf(chr);
				var closedChr = closeBrackets.get(indexOfOpenChar);
				stack.addLast(closedChr);
			} else if (stack.isEmpty()) {
				return false;
			} else if (stack.pollLast() != (Character) chr) {
				return false;
			}
		}

		return stack.isEmpty();
	}

}
