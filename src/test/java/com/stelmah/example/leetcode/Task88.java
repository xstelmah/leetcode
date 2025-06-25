
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task88 {


    @Test
    void example1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        Assertions.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }

    @Test
    void example2() {
        int[] nums1 = {7, 0, 0, 0};
        int m = 1;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        Assertions.assertArrayEquals(new int[]{2, 5, 6, 7}, nums1);
    }

    @Test
    void example3() {
        int[] nums1 = {0, 0, 0};
        int m = 0;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        Assertions.assertArrayEquals(new int[]{2, 5, 6}, nums1);
    }

    @Test
    void example4() {
        int[] nums1 = {2, 5, 6};
        int m = 3;
        int[] nums2 = {};
        int n = 0;

        merge(nums1, m, nums2, n);

        Assertions.assertArrayEquals(new int[]{2, 5, 6}, nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        var size = m + n;
        for (int i = size - 1; i > size - 1 - m; i--) {
            nums1[i] = nums1[i - n];
        }

        int i = 0;
        int i1 = n;
        int i2 = 0;
        while (i < size) {
            if (i2 == n) {
                break;
            }
            if (i1 == size) {
                nums1[i++] = nums2[i2++];
                continue;
            }
            if (nums1[i1] < nums2[i2]) {
                nums1[i++] = nums1[i1++];
            } else {
                nums1[i++] = nums2[i2++];
            }
        }
    }

}
