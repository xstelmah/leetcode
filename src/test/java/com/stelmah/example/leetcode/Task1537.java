
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task1537 {


    @Test
    void example1() {
        int[] num1 = {2, 4, 5, 8, 10};
        int[] num2 = {4, 6, 8, 9};
        Assertions.assertEquals(30, maxSum(num1, num2));
    }

    public int maxSum(int[] nums1, int[] nums2) {
        var n1 = nums1.length;
        var n2 = nums2.length;
        var i1 = 0;
        var i2 = 0;
        long sum1 = 0;
        long sum2 = 0;
        while (i1 < n1 && i2 < n2) {
            if (nums1[i1] == nums2[i2]) {
                sum1 = Math.max(sum1, sum2);
                sum2 = sum1;
                sum1 += nums1[i1++];
                sum2 += nums2[i2++];
            } else if (nums1[i1] > nums2[i2]) {
                sum2 += nums2[i2++];
            } else {
                sum1 += nums1[i1++];
            }
        }
        while (i1 < n1) sum1 += nums1[i1++];
        while (i2 < n2) sum2 += nums2[i2++];
        return (int) (Math.max(sum1, sum2) % 1_000_000_007);
    }

}
