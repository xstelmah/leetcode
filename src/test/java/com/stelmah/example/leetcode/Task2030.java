package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task2030 {

    @Test
    void example1() {
        var s = "leetcode";
        var k = 4;
        var letter = 'e';
        var repetition = 2;
        var result = smallestSubsequence(s, k, letter, repetition);
        Assertions.assertEquals("ecde", result);
    }

    @Test
    void example2() {
        var s = "leet";
        var k = 3;
        var letter = 'e';
        var repetition = 1;
        var result = smallestSubsequence(s, k, letter, repetition);
        Assertions.assertEquals("eet", result);
    }

    @Test
    void example3() {
        var s = "leete";
        var k = 1;
        var letter = 'e';
        var repetition = 1;
        var result = smallestSubsequence(s, k, letter, repetition);
        Assertions.assertEquals("e", result);
    }

    @Test
    void example4() {
        var s = "aaabbbcccddd";
        var k = 3;
        var letter = 'b';
        var repetition = 2;
        var result = smallestSubsequence(s, k, letter, repetition);
        Assertions.assertEquals("abb", result);
    }

    @Test
    void example5() {
        var s = "bezzzzzszvvwxxxz";
        var k = 7;
        var letter = 'z';
        var repetition = 5;
        var result = smallestSubsequence(s, k, letter, repetition);
        Assertions.assertEquals("bezzzzz", result);
    }

    /**
     * Too complex solution... Just proof of concept.
     */
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        if (k == 1) {
            return s.contains("" + letter) ? ("" + letter) : "";
        }
        var listNode = new ListNode();
        var usedLetterCount = 0;
        var currentLetterCount = 0;
        var totalLetterCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                totalLetterCount++;
            }
        }
        for (int i = 0; i < k; i++) {
            listNode.addLast(new Node(s.charAt(i)));
            if (s.charAt(i) == letter) {
                currentLetterCount++;
                usedLetterCount++;
            }
        }
        var current = listNode.first;
        var index = k;
        while (index < s.length()) {
            var chr = s.charAt(index++);
            var isMandatory = isMandatory(letter, chr, usedLetterCount, currentLetterCount, totalLetterCount, repetition);
            if (isMandatory) {
                while (current.next != null && (current.val <= current.next.val
                        || !isRemovable(current, letter, chr, usedLetterCount, currentLetterCount, totalLetterCount, repetition))) {
                    current = current.next;
                }
                if (current.val == letter) {
                    current = listNode.last;
                    while (current.val == letter) {
                        current = current.prev;
                    }
                }
            } else {
                while (current.next != null && (current.val <= current.next.val
                        || !isRemovable(current, letter, chr, usedLetterCount, currentLetterCount, totalLetterCount, repetition))) {
                    current = current.next;
                }
            }

            if ((current.next != null && current.val > current.next.val)
                    || (current.next == null && current.val > chr && isRemovable(current, letter, chr, usedLetterCount, currentLetterCount, totalLetterCount, repetition))
                    || isMandatory) {
                var prev = current.prev;
                listNode.remove(current);
                if (current.val == letter) {
                    currentLetterCount--;
                }
                current = (prev != null) ? prev : listNode.first;
                listNode.addLast(new Node(chr));
                if (chr == letter) {
                    currentLetterCount++;
                }
            }

            if (chr == letter) {
                usedLetterCount++;
            }
        }


        return listNode.toString();
    }

    public static boolean isRemovable(Node node, char letter, char newLetter, int usedLetterCount, int currentLetterCount, int totalLetterCount, int repetition) {
        if (node.val != letter || (newLetter == letter && currentLetterCount >= repetition)) {
            return true;
        }
        return usedLetterCount - currentLetterCount + repetition < totalLetterCount;
    }

    public static boolean isMandatory(char letter, char newLetter, int usedLetterCount, int currentLetterCount, int totalLetterCount, int repetition) {
        if (newLetter != letter) {
            return false;
        }
        return usedLetterCount - currentLetterCount + repetition >= totalLetterCount;
    }

    public static class ListNode {
        public Node first;
        public Node last;

        public void remove(Node node) {
            if (first == node && first != null) {
                first = first.next;
            }
            if (last == node && last != null) {
                last = last.prev;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }

        public void addLast(Node node) {
            if (first == null) {
                first = node;
            }
            if (last == null) {
                last = node;
            } else {
                last.next = node;
                node.prev = last;
                last = node;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            var node = first;
            while (node != null) {
                sb.append(node.val);
                node = node.next;
            }
            return sb.toString();
        }
    }

    public static class Node {
        public Node prev;
        public Node next;
        public char val;

        public Node(char val) {
            this.val = val;
        }

        public Node(Node prev, Node next, char val) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
    }

}