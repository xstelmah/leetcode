package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;


class Task1049 {

    @Test
    void example1() {
        var stones = new int[]{2, 7, 4, 1, 8, 1};
        var response = lastStoneWeightII(stones);
        Assertions.assertEquals(1, response);
    }

    @Test
    void example2() {
        var stones = new int[]{31, 26, 33, 21, 40};
        var response = lastStoneWeightII(stones);
        Assertions.assertEquals(5, response);
    }

    public int lastStoneWeightII(int[] stones) {
        var currentState = new HashSet<Integer>();
        currentState.add(stones[0]);

        for (int i = 1; i < stones.length; i++) {
            var newState = new HashSet<Integer>();
            for (int state : currentState) {
                newState.add(Math.abs(state - stones[i]));
                newState.add(state + stones[i]);
            }
            currentState = newState;
        }
        var min = Integer.MAX_VALUE;
        for (Integer state : currentState) {
            min = Math.min(min, state);
        }

        return min;
    }

}
