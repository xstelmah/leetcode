
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Test;


class Task75 {


    @Test
    void example1() {

    }

    public void sortColors(int[] nums) {
        var arr = new int[3];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        var index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                nums[index++] = i;
            }
        }
    }

}
