package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Task2870 {

    @Test
    void example1() {
        int[] nums = {2, 3, 3, 2, 2, 4, 2, 3, 4};

        Assertions.assertEquals(4, minOperations(nums));
    }

    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        var prev = 0;
        var cnt = 0;
        var answer = 0;

        for (int i = 0; i <= nums.length; i++) {
            var num = i != nums.length ? nums[i] : 0;
            if (prev == num) {
                cnt++;
            } else {
                if (cnt == 1) {
                    return -1;
                } else if (cnt % 3 == 0) {
                    answer += cnt / 3;
                } else if (cnt % 3 == 2) {
                    answer += cnt / 3 + 1;
                } else {
                    answer += (cnt - 4) / 3 + 2;
                }

                cnt = 1;
                prev = num;
            }
        }
        return answer;
    }

}
