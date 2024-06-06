package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Task212_2 {

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
        HashSet<String> result;

        public List<String> findWords(char[][] board, String[] words) {
            var rows = board.length;
            var columns = board[0].length;

            result = new HashSet<String>();

            for (var word : words) {
                root.insert(word);
            }

            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    verify(board, root.root.getCharNode(board[row][column]), 1, row, column);
                }
            }

            return new ArrayList<String>(result);
        }

        void verify(char[][] board, Node node, int level, int row, int column) {
            if (node == null) {
                return;
            }
            var chr = board[row][column];

            if (node.word != null) {
                result.add(node.word);
            }

            if (level == 10) {
                return;
            }
            board[row][column] = '.';

            if (verifyChar(board, row + 1, column))
                verify(board, node.getCharNode(board[row + 1][column]), level + 1, row + 1, column);
            if (verifyChar(board, row - 1, column))
                verify(board, node.getCharNode(board[row - 1][column]), level + 1, row - 1, column);
            if (verifyChar(board, row, column + 1))
                verify(board, node.getCharNode(board[row][column + 1]), level + 1, row, column + 1);
            if (verifyChar(board, row, column - 1))
                verify(board, node.getCharNode(board[row][column - 1]), level + 1, row, column - 1);

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


        static class Trie {

            Node root;

            public Trie() {
                root = new Node();
            }

            public void insert(String word) {
                var node = root;
                for (var chr : word.toCharArray()) {
                    node = node.addChar(chr);
                }
                node.word = word;
            }


        }

        public static class Node {
            Node[] childs = new Node[26];
            String word;


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
