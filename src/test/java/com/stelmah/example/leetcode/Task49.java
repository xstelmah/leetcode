package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Task49 {

	@Test
	void example1() {
		var strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		Assertions.assertEquals(3, groupAnagrams(strs).size());
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<Long, List<Group>> map = new HashMap<>();
		for (String str : strs) {
			var group = new Group(str);
			var list = map.getOrDefault(group.getHash(), new ArrayList<>());
			list.add(group);
			map.put(group.getHash(), list);
		}
		return map.values()
				.stream()
				.map(groups -> groups.stream().map(q -> q.str).collect(Collectors.toList()))
				.collect(Collectors.toList());
	}

	private static class Group {
		public Long hash;
		public String str;
		public char[] arr = new char[27];

		public Group(String str) {
			this.str = str;

			for (int i = 0; i < str.length(); i++) {
				arr[str.charAt(i) - 'a']++;
			}
		}

		public long getHash() {
			if (hash == null) {
				hash = 1L;
				for (int i = 0; i < arr.length; i++) {
					hash = hash * 101 + arr[i];
				}
			}
			return hash;
		}

	}

}
