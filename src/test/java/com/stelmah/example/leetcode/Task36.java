package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class Task36 {

	@Test
	void example1() {
		var board = new char[][] { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		Assertions.assertEquals(false, isValidSudoku(board));
	}

	@Test
	void example2() {
		var board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		Assertions.assertEquals(true, isValidSudoku(board));
	}

	public boolean isValidSudoku(char[][] board) {
		var set = new HashSet<Integer>();
		var row = 0;
		var column = 0;
		var cell = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					row = 100 + i * 10 + (board[i][j] - '0');
					column = 200 + j * 10 + (board[i][j] - '0');
					cell = 3000 + round(i) * 100 + round(j) * 10 + (board[i][j] - '0');
					if (set.contains(row) || set.contains(column) || set.contains(cell)) {
						return false;
					} else {
						set.add(row);
						set.add(column);
						set.add(cell);
					}
				}
			}
		}
		return true;
	}

	public int round(int num) {
		return num - num % 3;
	}

}
