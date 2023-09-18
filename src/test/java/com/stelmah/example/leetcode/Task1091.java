package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

class Task1091 {

	@Test
	void example1() {
		var grid = new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
		var response = shortestPathBinaryMatrix(grid);
		Assertions.assertEquals(4, response);
	}

	public int shortestPathBinaryMatrix(int[][] grid) {
		var queue = new ArrayDeque<Element>();
		queue.add(new Element(0, 0, 1));
		var dx = new int[] { 1, 1, -1, -1, 0, 1, 0, -1 };
		var dy = new int[] { 1, -1, 1, -1, 1, 0, -1, 0 };
		while (!queue.isEmpty()) {
			var element = queue.poll();
			if (element.y == grid.length - 1 && element.x == grid.length - 1 && grid[element.y][element.x] == 0) {
				return element.step;
			}
			if (grid[element.y][element.x] == 0) {
				grid[element.y][element.x] = 1;
				for (int i = 0; i < 8; i++) {
					var newX = element.x + dx[i];
					var newY = element.y + dy[i];
					if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid.length && grid[newY][newX] == 0) {
						queue.add(new Element(newX, newY, element.step + 1));
					}
				}
			}
		}
		return -1;
	}

	public static class Element {
		int x;
		int y;
		int step = 0;

		public Element(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}

	}

}
