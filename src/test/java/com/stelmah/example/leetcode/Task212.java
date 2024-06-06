package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task212 {

    @Test
    void example1() {
        var s = new Solution();
        char[][] board = {{'a', 'b'}};
        String[] words = {"ba"};
        var res = s.findWords(board, words);

        Assertions.assertArrayEquals(new String[]{"ba"}, res.toArray());
    }

    class Solution {

        Trie root = new Trie();
        int maxLevel = 10;

        public List<String> findWords(char[][] board, String[] words) {
            var rows = board.length;
            var columns = board[0].length;

            maxLevel = Math.min(10, rows * columns);

            var result = new ArrayList<String>();

            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    verify(board, new char[maxLevel], 1, row, column);
                }
            }

            for (var word : words) {
                if (root.startsWith(word)) {
                    result.add(word);
                }
            }

            return result;
        }

        void verify(char[][] board, char[] word, int level, int row, int column) {
            var chr = board[row][column];
            word[level - 1] = chr;

            if (level == maxLevel || isEndPos(board, row, column)) {
                System.out.println(word);
                root.insert(word, level);
                return;
            }
            board[row][column] = '.';

            if (verifyChar(board, row + 1, column)) verify(board, word, level + 1, row + 1, column);
            if (verifyChar(board, row - 1, column)) verify(board, word, level + 1, row - 1, column);
            if (verifyChar(board, row, column + 1)) verify(board, word, level + 1, row, column + 1);
            if (verifyChar(board, row, column - 1)) verify(board, word, level + 1, row, column - 1);

            board[row][column] = chr;
        }

        boolean verifyChar(char[][] board, int row, int column) {
            if (row < 0 || column < 0 || row >= board.length || column >= board[0].length) {
                return false;
            }
            if (board[row][column] == '.') {
                return false;
            }
            return true;
        }


        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        boolean isEndPos(char[][] board, int row, int column) {
            for (var i = 0; i <= 3; i++) {
                var y = row + dy[i];
                var x = column + dx[i];
                if (y < 0 || x < 0 || y >= board.length || x >= board[0].length) {
                    continue;
                }
                if (board[y][x] != '.') {
                    return false;
                }
            }
            return true;
        }


        static class Trie {

            Node root;

            public Trie() {
                root = new Node();
            }

            public void insert(char[] chars, int level) {
                var node = root;
                for (int i = 0; i < level; i++) {
                    node = node.addChar(chars[i]);
                }
            }

            public boolean startsWith(String prefix) {
                var node = root;
                for (var chr : prefix.toCharArray()) {
                    node = node.getCharNode(chr);
                    if (node == null) {
                        return false;
                    }
                }
                return true;
            }

            public static class Node {
                Node[] childs = new Node[26];


                Node getCharNode(char chr) {
                    return childs[chr - 'a'];
                }

                Node addChar(char chr) {
                    if (childs[chr - 'a'] == null) {
                        childs[chr - 'a'] = new Node();
                    }
                    return childs[chr - 'a'];
                }

            }
        }
    }

}
