
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task53 {



    @Test
    void example2() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        Assertions.assertEquals(6, maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        var answer = nums[0];
        var sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum + nums[i] > nums[i]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }

}
