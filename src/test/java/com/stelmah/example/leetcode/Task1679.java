
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;


class Task1679 {


    @Test
    void example1() {
        int[] nums = {1, 2, 3, 4};
        var k = 5;

        Assertions.assertEquals(2, maxOperations(nums, k));
    }


    public int maxOperations(int[] nums, int k) {
        var answer = 0;
        var mp = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            var target = k - nums[i];
            if (mp.containsKey(target) && mp.get(target) > 0) {
                mp.put(target, mp.get(target) - 1);
                answer++;
            } else {
                mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            }
        }
        return answer;
    }
}
