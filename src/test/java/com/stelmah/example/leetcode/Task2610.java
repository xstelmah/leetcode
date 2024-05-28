package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task2610 {

    @Test
    void example1() {
        int[] nums = {1, 3, 4, 1, 2, 3, 1};

        Assertions.assertEquals(3, findMatrix(nums).size());
    }


    public List<List<Integer>> findMatrix(int[] input) {
        var len = input.length;
        var answers = new ArrayList<List<Integer>>();
        var nums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            nums[input[i]]++;
        }
        for (int i = 0; i <= len; i++) {
            var list = new ArrayList<Integer>();
            for (int j = 0; j <= len; j++) {
                if (nums[j] > 0) {
                    list.add(j);
                    nums[j]--;
                }
            }
            if (list.isEmpty()) {
                break;
            }
            answers.add(list);
        }
        return answers;
    }

}
