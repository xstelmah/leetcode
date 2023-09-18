package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class Task659 {

	@Test
	void example1() {
		var s = "UD";
		Assertions.assertEquals(true, judgeCircle(s));
	}

	@Test
	void example2() {
		var s = "LL";
		Assertions.assertEquals(false, judgeCircle(s));
	}

	public boolean judgeCircle(String moves) {
		var row = 0;
		var column = 0;
		for (char c : moves.toCharArray()) {
			switch (c) {
				case 'U':
					row++;
					break;
				case 'D':
					row--;
					break;
				case 'L':
					column--;
					break;
				case 'R':
					column++;
					break;
			}

		}
		return column == 0 && row == 0;
	}

}
