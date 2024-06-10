package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task42_2 {

    @Test
    void example1() {
        var height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Assertions.assertEquals(6, trap(height));
    }

    @Test
    void example2() {
        var height = new int[]{4, 2, 0, 3, 2, 5};
        Assertions.assertEquals(9, trap(height));
    }

    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        var l = 0;
        var r = height.length - 1;

        var lMax = height[l];
        var rMax = height[r];
        var answer = 0;
        while (l < r) {
            if (lMax <= rMax) {
                if (lMax <= height[l + 1]) {
                    lMax = height[++l];
                    continue;
                }
                answer += lMax - height[++l];
            } else {
                if (rMax <= height[r - 1]) {
                    rMax = height[--r];
                    continue;
                }
                answer += rMax - height[--r];
            }
        }

        return answer;
    }

}
