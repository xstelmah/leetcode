
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task477 {

    @Test
    void example1() {
        int[] nums = {4, 14, 2};
        Assertions.assertEquals(6, totalHammingDistance(nums));
    }


    /**
     * 1110
     * 0100
     * 0010
     * 1111
     * 0000
     * number of bits = 1 / total number of bits
     * 2/5 + 3/5 + 3/5 + 1/5
     * <p>
     * 2 * (5-2) = 6
     * 3 * (5-3) = 6
     * ...
     * Beats 90% -> 4 ms
     */
    public int totalHammingDistance(int[] nums) {
        var answer = 0;
        for (int i = 0; i <= 31; i++) {
            var cntOfBits = 0;
            for (int j = 0; j < nums.length; j++) {
                cntOfBits += (nums[j] >>> i) & 1;
            }
            answer += cntOfBits * (nums.length - cntOfBits);
        }
        return answer;
    }

    /** Beats 100% -> 3ms **/
    public int totalHammingDistance2(int[] nums) {
        int answer = 0, i = 0, j = 0, cntOfBits = 0, len = nums.length;
        for (; i <= 31; i++) {
            cntOfBits = 0;
            for (j = 0; j < len; j++) {
                cntOfBits += (nums[j] >>> i) & 1;
            }
            answer += cntOfBits * (len - cntOfBits);
        }
        return answer;
    }

}
