
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class Task1007 {

    @Test
    void example1() {
        int[] tops = {2, 1, 2, 4, 2, 2};
        int[] bottoms = {5, 2, 6, 2, 3, 2};
        Assertions.assertEquals(2, minDominoRotations(tops, bottoms));
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        var answer = Integer.MAX_VALUE;

        for (int i = 1; i <= 6; i++) {
            answer = Math.min(answer, verify(tops, bottoms, i));
            answer = Math.min(answer, verify(bottoms, tops, i));
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public int verify(int[] source, int[] target, int dice) {
        int cnt = 0;
        for (int i = 0; i < source.length; i++) {
            if (source[i] != dice) {
                if (target[i] != dice) {
                    return Integer.MAX_VALUE;
                }
                cnt++;
            }
        }
        return cnt;
    }
}
