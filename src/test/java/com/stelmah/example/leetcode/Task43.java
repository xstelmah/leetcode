package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

class Task43 {

	@Test
	void example1() {
		var result = multiply("999", "99");

		Assertions.assertEquals("98901", result);
	}

	@Test
	void example2() {
		var result = multiply("123", "1");

		Assertions.assertEquals("123", result);
	}

	@Test
	void example3() {
		var result = multiply("96", "313");

		Assertions.assertEquals("30048", result);
	}

	@Test
	void example4() {
		var result = multiply("313", "96");

		Assertions.assertEquals("30048", result);
	}

	public String multiply(String num1, String num2) {
		if ("0".equals(num1) || "0".equals(num2)) {
			return "0";
		}
		var totalLength = num1.length() + num2.length();
		var response = new int[totalLength];
		var chars1 = num1.toCharArray();
		var chars2 = num2.toCharArray();

		for (int i = chars1.length - 1; i >= 0; i--) {
			for (int j = chars2.length - 1; j >= 0; j--) {
				var operationResult = (chars1[i] - '0') * (chars2[j] - '0');
				response[i + j + 1] += operationResult % 10;
				if (response[i + j + 1] > 9) {
					response[i + j + 1] -= 10;
					response[i + j]++;
				}
				response[i + j] += operationResult / 10;
				if (response[i + j] > 9) {
					response[i + j] -= 10;
					response[i + j - 1]++;
				}
			}
		}
		var sb = new StringBuilder();
		var started = false;
		for (int i = 0; i < response.length; i++) {
			if (response[i] != 0) {
				started = true;
			}
			if (started) {
				sb.append(response[i]);
			}
		}
		return sb.toString();
	}

}
