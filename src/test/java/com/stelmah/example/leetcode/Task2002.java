
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task2002 {


    @Test
    void example2() {
        var s = "leetcodecom";

        Assertions.assertEquals(9, maxProduct(s));
    }

    @Test
    void example3() {
        var s = "aaaaaaaaaaaa";

        Assertions.assertEquals(36, maxProduct(s));
    }


    public int maxProduct(String s) {
        var dp = new int[1 << s.length()];
        var answer = 0;
        for (int mask = 1; mask < dp.length; mask++) {
            dp[mask] = calcPalindromeLength(mask, s);
        }


        for (int mask1 = 1; mask1 < dp.length; mask1++) {
            if (dp[mask1] > 0) {
                for (int mask2 = mask1 + 1; mask2 < dp.length; mask2++) {
                    if (dp[mask2] > 0 && (mask1 & mask2) == 0) {
                        answer = Math.max(answer, dp[mask1] * dp[mask2]);
                    }
                }
            }
        }

        return answer;
    }

    char[] chars = new char[12];

    private int calcPalindromeLength(int mask, String s) {
        var bits = 0;
        for (int bit = 0; bit < 12; bit++) {
            if ((mask & (1 << bit)) != 0) {
                chars[bits++] = s.charAt(bit);
            }
        }
        for (int i = 0; i < bits / 2; i++) {
            if (chars[i] != chars[bits - i - 1]) {
                return 0;
            }
        }
        return bits;
    }
}
