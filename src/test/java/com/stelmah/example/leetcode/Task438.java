package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

class Task438 {

	@Test
	void example1() {
		var s = "cbaebabacd";
		var p = "abc";
		var response = new Integer[] { 0, 6 };
		Assertions.assertArrayEquals(response, findAnagrams(s, p).toArray(Integer[]::new));
	}

	public List<Integer> findAnagrams(String s, String p) {
		if (s.length() < p.length()) {
			return List.of();
		}
		var response = new ArrayList<Integer>();
		var targetArr = new int[26];

		for (char c : p.toCharArray()) {
			targetArr[c - 'a']++;
		}
		var slidingArr = new int[26];

		for (int i = 0; i < s.length(); i++) {
			if (i < p.length()) {
				slidingArr[s.charAt(i) - 'a']++;
				if (i == p.length() - 1) {
					if (compareArrays(slidingArr, targetArr)) {
						response.add(i - p.length() + 1);
					}
				}
			} else {
				slidingArr[s.charAt(i - p.length()) - 'a']--;
				slidingArr[s.charAt(i) - 'a']++;
				if (compareArrays(slidingArr, targetArr)) {
					response.add(i - p.length() + 1);
				}
			}
		}
		return response;
	}

	boolean compareArrays(int[] slidingArr, int[] targetArr) {
		return Arrays.equals(slidingArr, targetArr);
	}

}
