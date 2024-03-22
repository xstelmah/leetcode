package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


class Task1814 {

    @Test
    void example1() {
        var nums = new int[]{42, 11, 1, 97};
        var response = countNicePairs(nums);
        Assertions.assertEquals(2, response);
    }

    @Test
    void example2() {
        var nums = new int[]{13,10,35,24,76};
        var response = countNicePairs(nums);
        Assertions.assertEquals(4, response);
    }

    public int countNicePairs(int[] nums) {
        var mp = new HashMap<Long, Integer>();
        var answer = 0L;
        for (int num : nums) {
            var revnum = rev(num);
            var cnt = mp.getOrDefault(revnum-num, 0);
            mp.put(revnum-num, cnt + 1);
        }
        for (int val: mp.values()) {
            if (val > 1) {
                answer += (long) val * (val - 1) / 2;
            }
        }
        return (int)(answer % 1_000_000_007);
    }

    public long rev(int num) {
        long result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }

}
