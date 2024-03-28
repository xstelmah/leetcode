
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task1525_2 {

    @Test
    void example1() {
        var s = "aacaba";
        Assertions.assertEquals(2, numSplits(s));
    }

    @Test
    void example2() {
        var s = "abcd";
        Assertions.assertEquals(1, numSplits(s));
    }

    public int numSplits(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        var leftArr = new int[s.length()];
        var rightArr = new int[s.length()];

        var leftNum = 0;
        var rightNum = 0;

        var n = s.length();

        for (int i = 0; i < n; i++) {

            leftNum |= (1 << (s.charAt(i) - 'a'));
            rightNum |= (1 << (s.charAt(n - 1 - i) - 'a'));

            leftArr[i] = Integer.bitCount(leftNum);
            rightArr[n - 1 - i] = Integer.bitCount(rightNum);
        }
        var answer = 0;
        for (int i = 1; i < n; i++) {
            if (leftArr[i - 1] == rightArr[i]) {
                answer++;
            }
        }
        return answer;
    }
}
