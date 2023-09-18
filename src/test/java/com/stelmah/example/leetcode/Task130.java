package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

class Task130 {

	@Test
	void example1() {
		var board = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		var result = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		solve(board);
		for (int i = 0; i < board.length; i++) {
			Assertions.assertArrayEquals(board, result);
		}
	}

	public void solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if ((i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) && board[i][j] == 'O') {
					fillBoard(board, i, j);
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '-') {
					board[i][j] = 'O';
				}
			}
		}
	}

	int[] dx = new int[] { 0, 0, 1, -1 };
	int[] dy = new int[] { 1, -1, 0, 0 };

	private void fillBoard(char[][] board, int y, int x) {
		board[y][x] = '-';
		for (int i = 0; i < 4; i++) {
			var newX = x + dx[i];
			var newY = y + dy[i];
			if (newY >= 0 && newY < board.length && newX >= 0 && newX < board[y].length && board[newY][newX] == 'O') {
				fillBoard(board, newY, newX);
			}
		}
	}

	public static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}