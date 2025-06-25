package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

class Task139 {

	@Test
	void example1() {
		var s = "leetcode";
		var wordDict = List.of("leet", "code");
		Assertions.assertEquals(true, wordBreak(s, wordDict));
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		var hashes = new HashSet<Integer>();
		for (var word: wordDict) {
			hashes.add(word.hashCode());
		}
		var chars = s.getBytes();
		var len = s.length();
		var dp2 = new boolean[len + 1];
		var dp = new int[len][len + 1]; // start pos, end pos + 1

		for (int start = 0; start < len; start++) {
			var hash = 0;
			for (int end = start; end < len; end++) {
				hash = hash * 31 + (chars[end] & 0xff);
				dp[start][end + 1] = hash;
			}
		}

		dp2[0] = true;
		for (int i = 1; i <= len; i++) {
			for (var j = 0; j < i; j++) {
				if (dp2[j] && hashes.contains(dp[j][i])) {
					dp2[i] = true;
					break;
				}
			}
		}
		return dp2[len];
	}


}