
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;


class Task805 {

    @Test
    void example1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        Assertions.assertEquals(true, splitArraySameAverage(nums));
    }

    @Test
    void example2() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        Assertions.assertEquals(true, splitArraySameAverage(nums));
    }

    @Test
    void example3() {
        int[] nums = {6795, 3310, 8624, 475, 7609, 7858, 7086, 8934, 6197, 2431, 3310, 760, 1432, 7518, 7068, 7182, 2681, 2679, 6461, 9928, 9651, 3258, 9346, 1666, 5400, 8384, 2751, 1234, 2183, 3520};
        Assertions.assertEquals(false, splitArraySameAverage(nums));
    }

    @Test
    void example4() {
        int[] nums = {18,0,16,2};
        Assertions.assertEquals(true, splitArraySameAverage(nums));
    }

    public boolean splitArraySameAverage(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int avg = 0;
        for (int i = 0; i < nums.length; i++) {
            avg += nums[i];
            nums[i] *= nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - avg;
        }

        var mp = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length / 2; i++) {
            var newMp = new HashMap<Integer, Integer>();
            for (var key : mp.keySet()) {
                newMp.compute(key, (k, v) -> (v == null) ? 1 : v + 1);
                newMp.compute(nums[i] + key, (k, v) -> (v == null) ? 1 : v + 1);
            }
            newMp.compute(nums[i], (k, v) -> (v == null) ? 1 : v + 1);
            mp = newMp;
        }
        var mp2 = new HashMap<Integer, Integer>();
        for (int i = nums.length / 2; i < nums.length; i++) {
            var newMp = new HashMap<Integer, Integer>();
            for (var key : mp2.keySet()) {
                newMp.compute(key, (k, v) -> (v == null) ? 1 : v + 1);
                newMp.compute(nums[i] + key, (k, v) -> (v == null) ? 1 : v + 1);
            }
            newMp.compute(nums[i], (k, v) -> (v == null) ? 1 : v + 1);
            mp2 = newMp;
        }
        var result = 0;
        for (var e : mp.entrySet()) {
            if (mp2.containsKey(-e.getKey())) {
                result += Math.min(e.getValue(), mp2.get(-e.getKey()));
            }
        }
        return result > 1 || mp.containsKey(0) || mp2.containsKey(0);
    }

}
