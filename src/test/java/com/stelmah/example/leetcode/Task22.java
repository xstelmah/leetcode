package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Task22 {

	@Test
	void example1() {
		var num = 3;

		System.out.println(generateParenthesis(num));
		Assertions.assertEquals(5, generateParenthesis(num).size());
	}

	@Test
	void example2() {
		var num = 1;

		System.out.println(generateParenthesis(num));
		Assertions.assertEquals(1, generateParenthesis(num).size());
	}

	public List<String> generateParenthesis(int n) {
		var response = new ArrayList<String>();
		generateParenthesis(n, 0, 0, "", response);
		return response;
	}

	public void generateParenthesis(int limit, int open, int close, String s, List<String> response) {
		if (open == limit && close == limit) {
			response.add(s);
			return;
		}
		if (open < limit) {
			generateParenthesis(limit, open + 1, close, s + "(", response);
		}
		if (close < limit && open > close) {
			generateParenthesis(limit, open, close + 1, s + ")", response);
		}
	}

}
