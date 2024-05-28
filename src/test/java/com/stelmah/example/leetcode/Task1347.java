package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1347 {

    @Test
    void example1() {
        var s = "bab";
        var t = "aba";
        Assertions.assertEquals(1, minSteps(s, t));
    }

    public int minSteps(String s, String t) {
        var chars = new int[26];

        for (var chr : s.toCharArray()) {
            chars[chr - 'a']++;
        }

        for (var chr : t.toCharArray()) {
            chars[chr - 'a']--;
        }


        var answer = 0;
        for (int i = 0; i < 26; i++) {
            answer += Math.abs(chars[i]);
        }

        return answer / 2;
    }

}
