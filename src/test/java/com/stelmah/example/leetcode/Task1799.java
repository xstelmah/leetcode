package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1799 {
    public static long steps = 0;

    @Test
    void example1() {
        var nums = new int[]{3, 4, 6, 8};
        Assertions.assertEquals(11, maxScore(nums));
    }

    @Test
    void example2() {
        var nums = new int[]{1, 2, 3, 4, 5, 6};
        Assertions.assertEquals(14, maxScore(nums));
    }


    @Test
    void example3() {
        var nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        Assertions.assertEquals(138, maxScore(nums));
    }

    @Test
    void example4() {
        var nums = new int[]{109497, 983516, 698308, 409009, 310455, 528595, 524079, 18036, 341150, 641864, 913962, 421869, 943382, 295019};
        Assertions.assertEquals(527, maxScore(nums));
    }

    public int maxScore(int[] nums) {
        return maxScoreRec(nums, new int[nums.length / 2 + 1][1 << nums.length], 1, 0);
    }


    public int maxScoreRec(int[] nums, int[][] dp, int depth, int mask) {
        if (depth > nums.length / 2) {
            return 0;
        }
        if (dp[depth][mask] == 0) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    var newMask = (1 << i) + (1 << j);
                    if ((mask & newMask) == 0) {
                        dp[depth][mask] = Math.max(dp[depth][mask],
                                gcd(nums[i], nums[j]) * depth + maxScoreRec(nums, dp, depth + 1, mask + newMask));
                    }
                }
            }
        }
        return dp[depth][mask];
    }

    public int gcd(int first, int second) {
        while (first != 0 && second != 0) {
            if (first > second) {
                first %= second;
            } else {
                second %= first;
            }
        }
        return first + second;
    }

}