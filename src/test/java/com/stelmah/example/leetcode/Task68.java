package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Task68 {

	@Test
	void example1() {
		var board = new String[] { "This", "is", "an", "example", "of", "text", "justification." };
		var response = new String[] { "This    is    an", "example  of text", "justification.  " };
		Assertions.assertArrayEquals(response, fullJustify(board, 16).toArray());
	}

	@Test
	void example2() {
		var board = new String[] { "Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do" };
		var response = new String[] { "Science  is  what we",
				"understand      well",
				"enough to explain to",
				"a  computer.  Art is",
				"everything  else  we",
				"do                  "};
		Assertions.assertArrayEquals(response, fullJustify(board, 20).toArray());
	}

	public List<String> fullJustify(String[] words, int maxWidth) {
		var start = 0;
		var end = 0;

		var response = new ArrayList<String>();
		do {
			var length = 0;
			var onlyWordsLength = 0;
			start = end;
			while (end < words.length && length + words[end].length() + (length == 0 ? 0 : 1) <= maxWidth) {
				length += words[end].length() + (length == 0 ? 0 : 1);
				onlyWordsLength += words[end].length();
				end++;
			}
			if (end == words.length || end - start == 1) {
				var sb = new StringBuilder();
				var space = false;
				while (start != end) {
					if (space) {
						sb.append(' ');
					}
					sb.append(words[start++]);
					space = true;
				}
				while (sb.length() != maxWidth)
					sb.append(' ');
				response.add(sb.toString());
			} else {
				var sb = new StringBuilder();
				var space = false;
				var count = end - start - 1;
				var tt = maxWidth - onlyWordsLength;
				var extraSpaces = tt % count;
				var spaces = tt / count;
				while (start != end) {
					if (space) {
						var i = 0;
						while (i < spaces + (extraSpaces > 0 ? 1 : 0)) {
							sb.append(' ');
							i++;
						}
						extraSpaces--;
					}
					sb.append(words[start++]);
					space = true;
				}
				response.add(sb.toString());
			}

		} while (end < words.length);
		return response;
	}

}
