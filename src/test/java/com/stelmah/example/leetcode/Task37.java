package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class Task37 {

	@Test
	void example1() {
		var board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		var target = new char[][] { { '5', '3', '4', '6', '7', '8', '9', '1', '2' },
				{ '6', '7', '2', '1', '9', '5', '3', '4', '8' }, { '1', '9', '8', '3', '4', '2', '5', '6', '7' },
				{ '8', '5', '9', '7', '6', '1', '4', '2', '3' }, { '4', '2', '6', '8', '5', '3', '7', '9', '1' },
				{ '7', '1', '3', '9', '2', '4', '8', '5', '6' }, { '9', '6', '1', '5', '3', '7', '2', '8', '4' },
				{ '2', '8', '7', '4', '1', '9', '6', '3', '5' }, { '3', '4', '5', '2', '8', '6', '1', '7', '9' } };
		solveSudoku(board);
		for (int i = 0; i < board.length; i++) {
			Assertions.assertArrayEquals(board[i], target[i]);
		}
	}

	@Test
	void example2() {
		var board = new char[][] { { '.', '.', '9', '7', '4', '8', '.', '.', '.' },
				{ '7', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '2', '.', '1', '.', '9', '.', '.', '.' },
				{ '.', '.', '7', '.', '.', '.', '2', '4', '.' }, { '.', '6', '4', '.', '1', '.', '5', '9', '.' },
				{ '.', '9', '8', '.', '.', '.', '3', '.', '.' }, { '.', '.', '.', '8', '.', '3', '.', '2', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '6' }, { '.', '.', '.', '2', '7', '5', '9', '.', '.' } };
		var target = new char[][] { { '3', '7', '9', '7', '4', '8', '6', '1', '2' },
				{ '7', '8', '1', '6', '3', '2', '4', '5', '9' }, { '4', '2', '6', '1', '5', '9', '8', '7', '3' },
				{ '5', '3', '7', '9', '8', '6', '2', '4', '1' }, { '2', '6', '4', '3', '1', '7', '5', '9', '8' },
				{ '1', '9', '8', '5', '2', '4', '3', '6', '7' }, { '9', '4', '5', '8', '6', '3', '1', '2', '5' },
				{ '8', '5', '2', '4', '9', '1', '7', '3', '6' }, { '6', '1', '3', '2', '7', '5', '9', '8', '4' } };
		solveSudoku(board);
		for (int i = 0; i < board.length; i++) {
			Assertions.assertArrayEquals(board[i], target[i]);
		}
	}

	@Test
	void example3() {
		var board = new char[][] { { '.', '.', '.', '2', '.', '.', '.', '6', '3' },
				{ '3', '.', '.', '.', '.', '5', '4', '.', '1' }, { '.', '.', '1', '.', '.', '3', '9', '8', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '9', '.' }, { '.', '.', '.', '5', '3', '8', '.', '.', '.' },
				{ '.', '3', '.', '.', '.', '.', '.', '.', '.' }, { '.', '2', '6', '3', '.', '.', '5', '.', '.' },
				{ '5', '.', '3', '7', '.', '.', '.', '.', '8' }, { '4', '7', '.', '.', '.', '1', '.', '.', '.' } };
		var target = new char[][] { { '8', '5', '4', '2', '1', '9', '7', '6', '3' },
				{ '3', '9', '7', '8', '6', '5', '4', '2', '1' }, { '2', '6', '1', '4', '7', '3', '9', '8', '5' },
				{ '7', '8', '5', '1', '2', '6', '3', '9', '4' }, { '6', '4', '9', '5', '3', '8', '1', '7', '2' },
				{ '1', '3', '2', '9', '4', '7', '8', '5', '6' }, { '9', '2', '6', '3', '8', '4', '5', '1', '7' },
				{ '5', '1', '3', '7', '9', '2', '6', '4', '8' }, { '4', '7', '8', '6', '5', '1', '2', '3', '9' } };
		solveSudoku(board);
		for (int i = 0; i < board.length; i++) {
			Assertions.assertArrayEquals(board[i], target[i]);
		}
	}

	@Test
	void example4() {
		var board = new char[][] { { '1', '.', '.', '.', '7', '.', '.', '3', '.' },
				{ '8', '3', '.', '6', '.', '.', '.', '.', '.' }, { '.', '.', '2', '9', '.', '.', '6', '.', '8' },
				{ '6', '.', '.', '.', '.', '4', '9', '.', '7' }, { '.', '9', '.', '.', '.', '.', '.', '5', '.' },
				{ '3', '.', '7', '5', '.', '.', '.', '.', '4' }, { '2', '.', '3', '.', '.', '9', '1', '.', '.' },
				{ '.', '.', '.', '.', '.', '2', '.', '4', '3' }, { '.', '4', '.', '.', '8', '.', '.', '.', '9' } };
		var target = new char[][] { { '1', '6', '9', '8', '7', '5', '4', '3', '2' },
				{ '8', '3', '4', '6', '2', '1', '7', '9', '5' }, { '5', '7', '2', '9', '4', '3', '6', '1', '8' },
				{ '6', '2', '5', '1', '3', '4', '9', '8', '7' }, { '4', '9', '8', '2', '6', '7', '3', '5', '1' },
				{ '3', '1', '7', '5', '9', '8', '2', '6', '4' }, { '2', '8', '3', '4', '5', '9', '1', '7', '6' },
				{ '9', '5', '6', '7', '1', '2', '8', '4', '3' }, { '7', '4', '1', '3', '8', '6', '5', '2', '9' } };
		solveSudoku(board);
		for (int i = 0; i < board.length; i++) {
			Assertions.assertArrayEquals(board[i], target[i]);
		}
	}

	@Test
	void example5() {
		var board = new char[][] { { '.', '.', '9', '7', '4', '8', '.', '.', '.' },
				{ '7', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '2', '.', '1', '.', '9', '.', '.', '.' },
				{ '.', '.', '7', '.', '.', '.', '2', '4', '.' }, { '.', '6', '4', '.', '1', '.', '5', '9', '.' },
				{ '.', '9', '8', '.', '.', '.', '3', '.', '.' }, { '.', '.', '.', '8', '.', '3', '.', '2', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '6' }, { '.', '.', '.', '2', '7', '5', '9', '.', '.' } };
		var target = new char[][] { { '5', '1', '9', '7', '4', '8', '6', '3', '2' },
				{ '7', '8', '3', '6', '5', '2', '4', '1', '9' }, { '4', '2', '6', '1', '3', '9', '8', '7', '5' },
				{ '3', '5', '7', '9', '8', '6', '2', '4', '1' }, { '2', '6', '4', '3', '1', '7', '5', '9', '8' },
				{ '1', '9', '8', '5', '2', '4', '3', '6', '7' }, { '9', '7', '5', '8', '6', '3', '1', '2', '4' },
				{ '8', '3', '2', '4', '9', '1', '7', '5', '6' }, { '6', '4', '1', '2', '7', '5', '9', '8', '3' } };
		solveSudoku(board);
		for (int i = 0; i < board.length; i++) {
			Assertions.assertArrayEquals(board[i], target[i]);
		}
	}
	@Test
	void example6() {
		var board = new char[][] {
				{ '.', '.', '9', '.', '.', '.', '.', '7', '.' },
				{ '.', '.', '.', '4', '.', '.', '.', '6', '.' },
				{ '5', '.', '.', '.', '.', '2', '9', '.', '4' },
				{ '.', '3', '.', '.', '.', '5', '.', '.', '.' },
				{ '.', '.', '.', '2', '.', '.', '1', '.', '8' },
				{ '.', '.', '.', '.', '.', '.', '.', '4', '.' },
				{ '.', '.', '.', '.', '2', '.', '7', '.', '.' },
				{ '6', '.', '.', '.', '1', '.', '.', '.', '.' },
				{ '.', '.', '1', '8', '.', '.', '2', '.', '9' } };
		var target = new char[][] { { '5', '1', '9', '7', '4', '8', '6', '3', '2' },
				{ '7', '8', '3', '6', '5', '2', '4', '1', '9' }, { '4', '2', '6', '1', '3', '9', '8', '7', '5' },
				{ '3', '5', '7', '9', '8', '6', '2', '4', '1' }, { '2', '6', '4', '3', '1', '7', '5', '9', '8' },
				{ '1', '9', '8', '5', '2', '4', '3', '6', '7' }, { '9', '7', '5', '8', '6', '3', '1', '2', '4' },
				{ '8', '3', '2', '4', '9', '1', '7', '5', '6' }, { '6', '4', '1', '2', '7', '5', '9', '8', '3' } };
		solveSudoku(board);
		for (int i = 0; i < board.length; i++) {
			Assertions.assertArrayEquals(board[i], target[i]);
		}
	}

	public void solveSudoku(char[][] board) {
		var baseSet = new HashSet<Integer>() {{
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
			add(6);
			add(7);
			add(8);
			add(9);
		}};
		rec(board, baseSet);
	}

	public boolean rec(char[][] board, HashSet<Integer> baseSet) {
		while (true) {
			if (isSolved(board)) {
				return true;
			}

			var isChanged = false;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (board[i][j] == '.') {
						var set = (Set<Integer>) baseSet.clone();
						if (set.size() > 0) {
							excludeByColumn(board, j, set);
						}
						if (set.size() > 0) {
							excludeByRow(board, i, set);
						}
						if (set.size() > 0) {
							excludeBy3x3GridPos(board, i, j, set);
						}
						if (set.size() > 0) {
							excludeBy2Rows2Columns(board, i, j, set);
						}
						if (set.size() > 0) {
							excludeByCheckAllEmptyRowsAndColumns(board, i, j, set);
						}
						if (set.size() > 0) {
							excludeBy3x3GridAndRowsAndColumns(board, i, j, set);
						}
						if (set.size() == 1) {
							board[i][j] = (char) ('0' + set.iterator().next());
							isChanged = true;
						}
						if (set.isEmpty()) {
							return false;
						}
					}
				}
			}
			if (!isChanged) {
				break;
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					var set = (Set<Integer>) baseSet.clone();
					excludeByColumn(board, j, set);
					if (set.size() > 0) {
						excludeByRow(board, i, set);
					}
					if (set.size() > 0) {
						excludeBy3x3GridPos(board, i, j, set);
					}
					if (set.isEmpty()) {
						return false;
					}
					if (set.size() >= 1) {
						var iterator = set.iterator();
						while (iterator.hasNext()) {
							var next = iterator.next();
							var boardCopy = deepCopyCharMatrix(board);
							boardCopy[i][j] = (char) ('0' + next);
							if (rec(boardCopy, baseSet)) {
								deepCopyCharMatrix(boardCopy, board);
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	public void excludeByRow(char[][] board, int row, Set<Integer> set) {
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] >= '1' && board[row][i] <= '9') {
				set.remove(board[row][i] - '0');
			}
		}
	}

	public void excludeByColumn(char[][] board, int column, Set<Integer> set) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][column] >= '1' && board[i][column] <= '9') {
				set.remove(board[i][column] - '0');
			}
		}
	}

	public void includeByRow(char[][] board, int row, int[] data) {
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] >= '1' && board[row][i] <= '9') {
				data[board[row][i] - '0']++;
			}
		}
	}

	public void includeByColumn(char[][] board, int column, int[] data) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][column] >= '1' && board[i][column] <= '9') {
				data[board[i][column] - '0']++;
			}
		}
	}

	public void excludeBy3x3GridPos(char[][] board, int row, int column, Set<Integer> set) {
		int row1 = round(row);
		int column1 = round(column);
		excludeBy3x3Grid(board, row1, column1, row1 + 2, column1 + 2, set);
	}

	public int round(int num) {
		return num - num % 3;
	}

	public void excludeBy3x3Grid(char[][] board, int row1, int column1, int row2, int column2, Set<Integer> set) {
		for (int row = row1; row <= row2; row++) {
			for (int column = column1; column <= column2; column++) {
				if (board[row][column] >= '1' && board[row][column] <= '9') {
					set.remove(board[row][column] - '0');
				}
			}
		}
	}

	public void excludeBy2Rows2Columns(char[][] board, int row, int column, Set<Integer> set) {
		int row1 = round(row);
		int column1 = round(column);
		int row2 = row1 + 2;
		int column2 = column1 + 2;
		var array = new int[10];
		for (int rowI = row1; rowI <= row2; rowI++) {
			if (rowI == row) {
				continue;
			}
			includeByRow(board, rowI, array);
		}
		for (int columnI = column1; columnI <= column2; columnI++) {
			if (columnI == column) {
				continue;
			}
			includeByColumn(board, columnI, array);
		}

		for (int i = 1; i <= 9; i++) {
			if (array[i] == 4 && set.contains(i)) {
				set.clear();
				set.add(i);
			}
		}
	}

	public void excludeBy3x3GridAndRowsAndColumns(char[][] board, int row, int column, Set<Integer> set) {
		int row1 = round(row);
		int column1 = round(column);
		int row2 = row1 + 2;
		int column2 = column1 + 2;
		for (Integer target : set) {
			var successfullyExcluded = true;
			for (int i = row1; i <= row2; i++) {
				if (successfullyExcluded) {
					for (int j = column1; j <= column2; j++) {
						if (board[i][j] == '.' && (i != row || j != column)) {
							successfullyExcluded = false;
							for (int z = 0; z < 9; z++) {
								if (board[i][z] == '0' + target) {
									successfullyExcluded = true;
								}
								if (board[z][j] == '0' + target) {
									successfullyExcluded = true;
								}
							}
							if (!successfullyExcluded) {
								break;
							}
						}
					}
				} else {
					break;
				}
			}
			if (successfullyExcluded) {
				set.clear();
				set.add(target);
				return;
			}
		}
	}

	private void excludeByCheckAllEmptyRowsAndColumns(char[][] board, int row0, int column0, Set<Integer> set) {
		var emptyRows = 0;
		var emptyColumns = 0;
		for (int i = 0; i < 9; i++) {
			if (board[i][column0] == '.' && i != row0) {
				emptyRows++;
			}
			if (board[row0][i] == '.' && i != column0) {
				emptyColumns++;
			}
		}
		for (Integer target : set) {
			// check for all rows
			var foundRows = 0;
			var foundColumns = 0;
			for (int i = 0; i < 9; i++) {
				if (board[i][column0] == '.' && i != row0) {
					for (int j = 0; j < 9; j++) {
						if (board[i][j] == '0' + target) {
							foundRows++;
						}
					}
				}
				if (board[row0][i] == '.' && i != column0) {
					for (int j = 0; j < 9; j++) {
						if (board[j][i] == '0' + target) {
							foundColumns++;
						}
					}
				}
			}
			if (foundRows == emptyRows) {
				set.clear();
				set.add(target);
				return;
			}
			if (foundColumns == emptyColumns) {
				set.clear();
				set.add(target);
				return;
			}
		}
	}

	public boolean isSolved(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					return false;
				}
			}
		}
		return true;
	}

	public static char[][] deepCopyCharMatrix(char[][] input) {
		if (input == null)
			return null;
		char[][] result = new char[input.length][];
		for (int r = 0; r < input.length; r++) {
			result[r] = input[r].clone();
		}
		return result;
	}

	public static void deepCopyCharMatrix(char[][] input, char[][] output) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				output[i][j] = input[i][j];
			}
		}
	}

}
