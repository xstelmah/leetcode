package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class Task1456 {

    @Test
    void example1() {
        var s = "abciiidef";
        var k = 3;

        Assertions.assertEquals(3, maxVowels(s, k));
    }

    Set<Character> chars = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        var max = 0;
        var temp = 0;
        var index = 0;
        while (index < s.length()) {
            if (chars.contains(s.charAt(index))) {
                temp++;
            }
            if (index >= k && chars.contains(s.charAt(index - k))) {
                temp--;
            }
            max = Math.max(max, temp);
            index++;
        }
        return max;
    }

}
