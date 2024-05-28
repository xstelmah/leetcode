package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task2125 {

    @Test
    void example1() {
        String[] bank = {"011001", "000000", "010100", "001000"};

        Assertions.assertEquals(8, numberOfBeams(bank));
    }


    public int numberOfBeams(String[] bank) {
        var prev = 0;
        var answer = 0;
        var n = bank.length;
        var m = bank[0].length();

        var cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt = 0;
            for (int j = 0; j < m; j++) {
                cnt += bank[i].charAt(j) - '0';
            }
            if (cnt != 0) {
                answer += prev * cnt;
                prev = cnt;
            }
        }
        return answer;
    }

}
