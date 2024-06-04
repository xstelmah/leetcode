package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task208 {

    @Test
    void example1() {
        var trie = new Trie();
        trie.insert("apple");
        Assertions.assertTrue(trie.search("apple"));   // return True
        Assertions.assertFalse(trie.search("app"));     // return False
        Assertions.assertTrue(trie.startsWith("app")); // return True
        trie.insert("app");
        Assertions.assertTrue(trie.search("app"));     // return True
    }

    static class Trie {

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            var node = root;
            for (var chr : word.toCharArray()) {
                node = node.addChar(chr, false);
            }
            node.end = true;
        }

        public boolean search(String word) {
            var node = root;
            for (var chr : word.toCharArray()) {
                node = node.getCharNode(chr);
                if (node == null) {
                    return false;
                }
            }
            return node.end;
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

}
