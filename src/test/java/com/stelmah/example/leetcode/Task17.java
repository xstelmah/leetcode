package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Task17 {

	@Test
	void example1() {
		var response = letterCombinations("23");
		Assertions.assertEquals(9, response.size());
	}

	char[][] variants = new char[][] { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
			{ 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) {
			return List.of();
		}
		var resp = new ArrayList<String>();
		letterCombinations(digits, "", resp);
		return resp;
	}

	public void letterCombinations(String digits, String prefix, List<String> response) {
		if (digits.length() == 0) {
			response.add(prefix);
		} else {
			var newDigits = digits.substring(1);
			var chr = digits.charAt(0);
			for (int i = 0; i < variants[chr - '0'].length; i++) {
				letterCombinations(newDigits, prefix + variants[chr - '0'][i], response);
			}
		}
	}

}
