package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Task1657 {

    @Test
    void example1() {
        var s = "bab";
        var t = "aba";
        Assertions.assertEquals(true, closeStrings(s, t));
    }

    public boolean closeStrings(String word1, String word2) {
        var chars1 = new int[26];
        var chars2 = new int[26];

        for (var chr : word1.toCharArray()) {
            chars1[chr - 'a']++;
        }

        for (var chr : word2.toCharArray()) {
            chars2[chr - 'a']++;
        }
        if (word1.length() != word2.length()) {
            return false;
        }

        for (int i = 0; i < 26; i++) {
            if (chars1[i] != 0 && chars2[i] == 0) {
                return false;
            }
            if (chars2[i] != 0 && chars1[i] == 0) {
                return false;
            }
        }

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

}
