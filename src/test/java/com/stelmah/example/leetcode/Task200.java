package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class Task200 {

	@Test
	void example1() {
		var num = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		var response = 1;
		Assertions.assertEquals(response, numIslands(num));
	}

	public int numIslands(char[][] grid) {
		var response = 0;

		var dx = new int[] { 0, 1, -1, 0 };
		var dy = new int[] { 1, 0, 0, -1 };

		var queue = new LinkedList<Pair>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					response++;
					queue.add(new Pair(j, i));

					while (!queue.isEmpty()) {
						var pair = queue.pollFirst();
						if (grid[pair.y][pair.x] == '1') {
							grid[pair.y][pair.x] = '0';
							for (int z = 0; z < 4; z++) {
								if (pair.y + dy[z] >= 0 && pair.y + dy[z] < grid.length && pair.x + dx[z] >= 0 && pair.x + dx[z] < grid[pair.y].length && grid[pair.y + dy[z]][pair.x + dx[z]] == '1') {
									queue.add(new Pair(pair.x + dx[z], pair.y + dy[z]));
								}
							}
						}
					}
				}
			}
		}

		return response;
	}

	public static class Pair {
		public int x;
		public int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
