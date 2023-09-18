package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task79 {

	@Test
	void example1() {
		var board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		var word = "ABCCED";
		Assertions.assertEquals(true, exist(board, word));
	}

	int[] dx = new int[] { 0, 1, -1, 0 };
	int[] dy = new int[] { 1, 0, 0, -1 };

	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					var chr = board[i][j];
					board[i][j] = '-';
					if (rec(board, word.substring(1), j, i)) {
						return true;
					}
					board[i][j] = chr;
				}
			}
		}
		return false;
	}

	public boolean rec(char[][] board, String word, int x, int y) {
		if (word.length() == 0) {
			return true;
		}
		for (int i = 0; i < 4; i++) {
			var newX = x + dx[i];
			var newY = y + dy[i];
			if (newY >= 0 && newY < board.length && newX >= 0 && newX < board[y].length && board[newY][newX] == word.charAt(0)) {
				var chr = board[newY][newX];
				board[newY][newX] = '-';
				if (rec(board, word.substring(1), newX, newY)) {
					return true;
				}
				board[newY][newX] = chr;
			}
		} return false;
	}

}
