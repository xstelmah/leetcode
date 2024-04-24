package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task91 {

    @Test
    void example1() {
        var s = "226";
        var expected = 3;

        Assertions.assertEquals(expected, numDecodings(s));
    }

    @Test
    void example2() {
        var s = "1111";
        var expected = 5;

        Assertions.assertEquals(expected, numDecodings(s));
    }

    @Test
    void example3() {
        var s = "2101";
        var expected = 1;

        Assertions.assertEquals(expected, numDecodings(s));
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        var dp = new int[s.length()];
        dp[0] = 1;
        var chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == 0) {
                continue;
            }

            if (chars[i] == '0') {
                if (chars[i - 1] == '0' || chars[i - 1] > '2') {
                    return 0;
                }
                dp[i] = dp[Math.max(i - 2, 0)];
                continue;
            }
            if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] < '7')) {
                dp[i] = dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 1);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }

}
