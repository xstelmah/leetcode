package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Task42 {

	@Test
	void example1() {
		var height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		Assertions.assertEquals(6, trap(height));
	}

	@Test
	void example2() {
		var height = new int[] { 4, 2, 0, 3, 2, 5 };
		Assertions.assertEquals(9, trap(height));
	}

	public int trap(int[] height) {
		var linkedList = new LinkedList<Element>();
		var index = 0;
		for (int i = 0; i < height.length; i++) {
			if (linkedList.size() <= 1) {
				linkedList.add(new Element(i, height[i], 0, 0));
			} else {
				var current = new Element(i, height[i], 0, 0);
				while (linkedList.size() >= 2 && linkedList.getLast().height <= current.height && linkedList.getLast().height <= linkedList
						.get(linkedList.size() - 2).height) {
					var middle = linkedList.removeLast();
					current.grouped += middle.grouped + middle.height;
				}
				linkedList.add(current);
			}
		}
		Element current = null;
		var next = linkedList.removeFirst();
		var response = 0;
		while (!linkedList.isEmpty()) {
			current = next;
			next = linkedList.removeFirst();
			response += (next.pos - current.pos - 1) * (Math.min(next.height, current.height)) - next.grouped;
		}
		return response;
	}

	public static class Element {
		public int pos;
		public int height;
		public int grouped;
		public int tempResponse;

		public Element(int pos, int height, int grouped, int tempResponse) {
			this.pos = pos;
			this.height = height;
			this.grouped = grouped;
			this.tempResponse = tempResponse;
		}

		@Override
		public String toString() {
			return "Element{" + "pos=" + pos + ", grouped=" + grouped + '}';
		}

	}

}
