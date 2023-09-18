package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Task12 {

	@Test
	void example1() {
		var num = 3;
		Assertions.assertEquals("III", intToRoman(num));
	}

	@Test
	void example2() {
		var num = 58;
		Assertions.assertEquals("LVIII", intToRoman(num));
	}

	@Test
	void example3() {
		var num = 1994;
		Assertions.assertEquals("MCMXCIV", intToRoman(num));
	}

	@Test
	void example4() {
		var num = 3724;
		Assertions.assertEquals("MMMDCCXXIV", intToRoman(num));
	}

	public String intToRoman(int num) {
		var key = new Character[] { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		var value = new int[] { 1, 5, 10, 50, 100, 500, 1000 };
		var sb = new StringBuilder();
		var currIndex = 6;
		while (num > 0) {
			while (value[currIndex] <= num) {
				sb.append(key[currIndex]);
				num -= value[currIndex];
			}
			while ((currIndex & 1) == 0 && currIndex - 2 >= 0 && value[currIndex] - value[currIndex - 2] <= num) {
				sb.append(key[currIndex - 2]);
				sb.append(key[currIndex]);
				num = num - value[currIndex] + value[currIndex - 2];
			}
			while ((currIndex & 1) == 1 && currIndex - 1 >= 0 && value[currIndex] - value[currIndex - 1] <= num) {
				sb.append(key[currIndex - 1]);
				sb.append(key[currIndex]);
				num = num - value[currIndex] + value[currIndex - 1];
			}
			currIndex--;
		}
		return sb.toString();
	}

}
