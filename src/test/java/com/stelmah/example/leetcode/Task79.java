package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task79 {

    @Test
    void example1() {
        var board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        var word = "ABCCED";
        Assertions.assertEquals(true, exist(board, word));
    }

    int[] dx = new int[]{0, 1, -1, 0};
    int[] dy = new int[]{1, 0, 0, -1};

    public boolean exist(char[][] board, String word) {
        var chars = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] == chars[0]) {
                    if (rec(board, chars, 0, x, y)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean rec(char[][] board, char[] chars, int pos, int x, int y) {
        if (pos == chars.length - 1) {
            return true;
        }
        var chr = board[y][x];
        board[y][x] = '.';

        for (int i = 0; i < 4; i++) {
            var newX = x + dx[i];
            var newY = y + dy[i];
            if (newY >= 0 && newY < board.length
                    && newX >= 0 && newX < board[y].length
                    && board[newY][newX] == chars[pos + 1]) {

                if (rec(board, chars, pos + 1, newX, newY)) {
                    return true;
                }
            }
        }

        board[y][x] = chr;
        return false;
    }

}
