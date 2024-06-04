package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task211 {

    @Test
    void example1() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        Assertions.assertFalse(wordDictionary.search("pad")); // return False
        Assertions.assertTrue(wordDictionary.search("bad")); // return True
        Assertions.assertTrue(wordDictionary.search(".ad")); // return True
        Assertions.assertTrue(wordDictionary.search("b..")); // return True
    }

    static class WordDictionary {

        Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            var node = root;
            for (var chr : word.toCharArray()) {
                node = node.addChar(chr, false);
            }
            node.end = true;
        }

        public boolean search(String word) {
            return search(word.toCharArray(), root, 0);
        }

        public boolean search(char[] chars, Node node, int start) {
            for (int i = start; i < chars.length; i++) {
                if (chars[i] == '.') {
                    var nodes = node.getDotNodes();
                    for (var nd : nodes) {
                        var res = search(chars, nd, i + 1);
                        if (res) return true;
                    }
                    return false;
                } else {
                    node = node.getCharNode(chars[i]);
                    if (node == null) {
                        return false;
                    }
                }
            }
            return node.end;
        }


        public static class Node {
            boolean end;
            Node[] childs = new Node[26];

            Node() {

            }

            Node(boolean end) {
                this.end = end;
            }

            Node getCharNode(char chr) {
                return childs[chr - 'a'];
            }

            List<Node> getDotNodes() {
                var response = new ArrayList<Node>();
                for (int i = 0; i < childs.length; i++) {
                    if (childs[i] != null) {
                        response.add(childs[i]);
                    }
                }
                return response;
            }

            Node addChar(char chr, boolean end) {
                if (childs[chr - 'a'] == null) {
                    childs[chr - 'a'] = new Node(end);
                } else {
                    childs[chr - 'a'].end |= end;
                }
                return childs[chr - 'a'];
            }

        }

    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

}
