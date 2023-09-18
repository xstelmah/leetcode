package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

class Task844 {

	@Test
	void example1() {
		var s = "ab#c";
		var t = "ad#c";
		Assertions.assertEquals(true, backspaceCompare(s, t));
	}

	public boolean backspaceCompare(String s, String t) {
		return clear(s).equals(clear(t));
	}

	private String clear(String s) {
		var stack = new LinkedList<Character>();
		for (char chr: s.toCharArray()			 ) {
			if (chr == '#') {
				stack.pollLast();
			} else {
				stack.offerLast(chr);
			}
		}

		return String.valueOf(stack);
	}

}
