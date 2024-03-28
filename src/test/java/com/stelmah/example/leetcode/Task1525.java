
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;


class Task1525 {

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

        var leftSet = new HashSet<Character>();
        var rightSet = new HashSet<Character>();

        var n = s.length();

        for (int i = 0; i < n; i++) {
            leftSet.add(s.charAt(i));
            rightSet.add(s.charAt(n - 1 - i));

            leftArr[i] = leftSet.size();
            rightArr[n - 1 - i] = rightSet.size();
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
