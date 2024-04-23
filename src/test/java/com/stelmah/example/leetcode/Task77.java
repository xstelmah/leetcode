package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Task77 {

    @Test
    void example1() {
        int n = 4;
        int k = 2;
        var result = combine(n, k);

        Assertions.assertEquals(6, result.size());
    }

    public List<List<Integer>> combine(int n, int k) {
        Integer[] stepAnswer = new Integer[k];
        var answers = new ArrayList<List<Integer>>();
        dfs(0, n, k, stepAnswer, answers);
        return answers;
    }


    public void dfs(int previous, int max, int size, Integer[] current, List<List<Integer>> answers) {
        if (size == 0) {
            answers.add(List.of(current));
            return;
        }
        for (int i = previous + 1; i <= max; i++) {
            current[current.length - size] = i;
            dfs(i, max, size - 1, current, answers);
        }
    }

}
