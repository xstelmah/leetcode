package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task547 {

	@Test
	void example1() {
		var isConnected = new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		var response = 2;
		Assertions.assertEquals(response, findCircleNum(isConnected));
	}

	public int findCircleNum(int[][] isConnected) {
		var response = 0;
		for (int y = 0; y < isConnected.length; y++) {
			for (int x = 0; x < isConnected.length; x++) {
				if (isConnected[y][x] == 1) {
					response++;
					eraseRec(isConnected, x, y);
				}
			}
		}
		return response;
	}

	public void eraseRec(int[][] isConnected, int x, int y) {
		isConnected[y][x] = 0;
		for (int i = 0; i < isConnected.length; i++) {
			if (isConnected[y][i] == 1) {
				eraseRec(isConnected, i, y);
			}
			if (isConnected[i][x] == 1) {
				eraseRec(isConnected, x, i);
			}
		}
	}

}
