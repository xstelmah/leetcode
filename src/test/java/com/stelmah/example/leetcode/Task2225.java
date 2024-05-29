package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task2225 {

    @Test
    void example1() {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};

        var target = findWinners(matches);
        var winners = target.get(0);
        var secondWinners = target.get(1);

        Integer[] expectedWinners = {1, 2, 10};
        Integer[] expectedSecondWinners = {4, 5, 7, 8};

        Assertions.assertArrayEquals(expectedWinners, winners.toArray());
        Assertions.assertArrayEquals(expectedSecondWinners, secondWinners.toArray());
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        var loses = new int[100_001];
        var victories = new int[100_001];

        var answer = new ArrayList<List<Integer>>();
        var winners = new ArrayList<Integer>();
        var losers = new ArrayList<Integer>();
        answer.add(winners);
        answer.add(losers);

        for (int i = 0; i < matches.length; i++) {
            loses[matches[i][1]]++;
            victories[matches[i][0]]++;
        }
        for (int i = 1; i <= 100_000; i++) {
            if (victories[i] > 0 && loses[i] == 0) {
                winners.add(i);
            } else if (loses[i] == 1) {
                losers.add(i);
            }
        }
        return answer;
    }
}
