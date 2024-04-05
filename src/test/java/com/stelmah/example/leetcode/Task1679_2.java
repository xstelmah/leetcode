
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class Task1679_2 {


    @Test
    void example1() {
        int[] nums = {1, 2, 3, 4};
        var k = 5;

        Assertions.assertEquals(2, maxOperations(nums, k));
    }


    public int maxOperations(int[] nums, int k) {
        var answer = 0;
        var l = 0;
        var r = nums.length - 1;
        Arrays.sort(nums);

        while (l < r) {
            while (l < r && nums[l] + nums[r] > k) r--;
            while (l < r && nums[l] + nums[r] < k) l++;
            while (l < r && nums[l] + nums[r] == k) {
                l++;
                r--;
                answer++;
            }
        }
        return answer;
    }
}
