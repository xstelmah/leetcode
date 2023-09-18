package com.stelmah.example.leetcode;

import com.sun.source.tree.BinaryTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

class Task1162 {

	@Test
	void example1() {
		var grid = new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
		Assertions.assertEquals(2, maxDistance(grid));
	}

	public int maxDistance(int[][] grid) {

		var resultGrid = new int[grid.length][grid.length];
		var dx = new int[] { 0, 0, 1, -1 };
		var dy = new int[] { 1, -1, 0, 0 };
		for (int i = 0; i < resultGrid.length; i++) {
			Arrays.fill(resultGrid[i], -1);
		}
		var queue = new LinkedList<Pos>();
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid.length; x++) {
				if (grid[y][x] == 1) {
					for (int i = 0; i < 4; i++) {
						var newX = x + dx[i];
						var newY = y + dy[i];
						if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid.length && grid[newY][newX] != 1) {
							queue.add(new Pos(newX, newY, 1));
						}
					}
				}
			}
		}
		while (!queue.isEmpty()) {
			var pos = queue.pollFirst();
			if (resultGrid[pos.y][pos.x] == -1) {
				resultGrid[pos.y][pos.x] = pos.step;
				for (int i = 0; i < 4; i++) {
					var newX = pos.x + dx[i];
					var newY = pos.y + dy[i];
					if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid.length && grid[newY][newX] != 1 && resultGrid[newY][newX] == -1) {
						queue.add(new Pos(newX, newY, pos.step+1));
					}
				}
			}
		}
		var max = -1;
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid.length; x++) {
				if (resultGrid[y][x] > max) {
					max = resultGrid[y][x];
				}
			}
		}

		return max;
	}

	public static class Pos {
		public int x;
		public int y;
		public int step;

		public Pos(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}

	}

}
