
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task904 {

    @Test
    void example1() {
        int[] fruits = {1, 2, 1};
        Assertions.assertEquals(3, totalFruit(fruits));
    }

    @Test
    void example2() {
        int[] fruits = {0, 1, 2, 2, 0};
        Assertions.assertEquals(3, totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {
        var n = fruits.length;
        var f1 = fruits[0];

        var f1Cnt = 0;


        var l = 0;
        var r = 0;
        while (r < n && f1 == fruits[r]) {
            r++;
            f1Cnt++;
        }
        if (r == n) {
            return n;
        }
        var answer = 0;
        while (true) {
            var f2 = fruits[r];
            var f2Cnt = 0;
            while (r < n && (f1 == fruits[r] || f2 == fruits[r])) {
                if (f1 == fruits[r]) {
                    f1Cnt++;
                } else {
                    f2Cnt++;
                }
                r++;
            }
            answer = Math.max(answer, r - l);
            if (r == n) {
                return answer;
            }
            while (f1Cnt != 0 && f2Cnt != 0) {
                if (f1 == fruits[l]) {
                    f1Cnt--;
                } else {
                    f2Cnt--;
                }
                l++;
            }
            if (f1Cnt == 0) {
                f1Cnt = f2Cnt;
                f1 = f2;
            }
        }
    }
}
