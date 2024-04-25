package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task58 {

    @Test
    void example1() {
        var s = "   fly me   to   the moon  ";
        Assertions.assertEquals(4, lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        var cnt = 0;
        var chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                if (cnt > 0) {
                    return cnt;
                }
            } else {
                cnt++;
            }
        }

        return cnt > 0 ? cnt : 0;
    }
}
