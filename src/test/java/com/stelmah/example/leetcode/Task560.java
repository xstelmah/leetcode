package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class Task560 {

    @Test
    void example1() {
        int[] nums = {1, 1, 1};
        var k = 2;
        Assertions.assertEquals(2, subarraySum(nums, k));
    }

    @Test
    void example2() {
        int[] nums = {1, 2, 3};
        var k = 3;
        Assertions.assertEquals(2, subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        var sum = 0;
        var answer = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            answer += map.getOrDefault(sum - k, 0);

            map.compute(sum, (key, v) -> (v == null) ? 1 : v + 1);
        }

        return answer;
    }

}