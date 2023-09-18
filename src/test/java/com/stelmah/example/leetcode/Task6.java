package com.stelmah.example.leetcode;

import com.jayway.jsonpath.internal.function.numeric.Max;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task6 {

	@Test
	void example1() {
		var s = "PAYPALISHIRING";
		var numRows = 3;
		Assertions.assertEquals("PAHNAPLSIIGYIR", convert(s, numRows));
	}

	@Test
	void example2() {
		var s = "PAYPALISHIRING";
		var numRows = 4;
		Assertions.assertEquals("PINALSIGYAHRPI", convert(s, numRows));
	}

	@Test
	void example3() {
		var s = "PAYPALISHIRING";
		var numRows = 1;
		Assertions.assertEquals("PAYPALISHIRING", convert(s, numRows));
	}

	@Test
	void example4() {
		var s = "PAYPALISHIRING";
		var numRows = 2;
		Assertions.assertEquals("PYAIHRNAPLSIIG", convert(s, numRows));
	}

	public String convert(String s, int numRows) {
		var sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			for (int j = i, step = Math.max((numRows - 1) * 2, 1); j < s.length(); j += step) {
				sb.append(s.charAt(j));
				if (i != 0 && i != numRows - 1 && j + (numRows - 1 - i) * 2 < s.length()) {
					sb.append(s.charAt(j + (numRows - 1 - i) * 2));
				}
			}
		}
		return sb.toString();
	}

}
