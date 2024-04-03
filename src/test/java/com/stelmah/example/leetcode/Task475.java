
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class Task475 {


    @Test
    void example1() {
        int[] houses = {1, 2, 3};
        int[] heaters = {2};
        Assertions.assertEquals(1, findRadius(houses, heaters));
    }
    @Test
    void example2() {
        int[] houses = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int[] heaters = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Assertions.assertEquals(0, findRadius(houses, heaters));
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        var hPos = 0;
        var answer = 0;

        for (int i = 0; i < houses.length; i++) {

            while (hPos + 1 < heaters.length
                    && Math.abs(heaters[hPos] - houses[i]) >= Math.abs(heaters[hPos + 1] - houses[i])) {
                hPos++;
            }
            answer = Math.max(answer, Math.abs(heaters[hPos] - houses[i]));
        }

        return answer;
    }
}
