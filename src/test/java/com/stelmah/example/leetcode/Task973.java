
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class Task973 {

    @Test
    void example1() {

    }

    @Test
    void example2() {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        var k = 2;
        var result = kClosest(points, k);
        Assertions.assertEquals(2, result.length);
        Assertions.assertArrayEquals(new int[]{3, 3}, result[0]);
        Assertions.assertArrayEquals(new int[]{-2, 4}, result[1]);
    }

    @Test
    void example3() {
        int[][] points = {{-63, -55}, {-20, 17}, {-88, -82}, {-90, -95}, {-88, 18}, {-62, -21}, {71, -64}, {-14, 56}, {65, 90}, {-48, -52}, {59, 92}, {-44, -59}, {-3, -66}};
        var k = 7;
        var result = kClosest(points, k);
        Assertions.assertEquals(7, result.length);
        int[][] expected = {{-20, 17}, {-14, 56}, {-62, -21}, {-3, -66}, {-48, -52}, {-44, -59}, {-63, -55}};
        Arrays.sort(expected, (o1, o2) -> sqPow(o1).compareTo(sqPow(o2)));
        Arrays.sort(result, (o1, o2) -> sqPow(o1).compareTo(sqPow(o2)));
        for (int i = 0; i < k; i++) {
            Assertions.assertArrayEquals(expected[i], result[i]);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        if (k != points.length) {
            partialQuickSort(points, k, 0, points.length - 1);
        }
        return Arrays.copyOfRange(points, 0, k);
    }


    public void partialQuickSort(int[][] points, int k, int low, int high) {
        var l = low;
        var r = high;
        int pivot = sqPow(points[(l + r)/2]);
        while (l <= r) {
            while (l <= r && sqPow(points[l]) < pivot) l++;
            while (l <= r && sqPow(points[r]) > pivot) r--;
            if (l <= r) {
                swap(points, l, r);
                l++;
                r--;
            }
        }

        if (k <= r) partialQuickSort(points, k, low, r);
        if (k >= l) partialQuickSort(points, k, l, high);
    }

    public void swap(int[][] points, int i, int j) {
        var tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    public int[][] kClosest0(int[][] points, int k) {
        var points2 = new int[points.length][2];
        for (int i = 0; i < points.length; i++) {
            points2[i][0] = (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            points2[i][1] = i;
        }
        Arrays.sort(points2, (p1, p2) -> ((Integer) p1[0]).compareTo(p2[0]));
        var answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            answer[i][0] = points[points2[i][1]][0];
            answer[i][1] = points[points2[i][1]][1];
        }
        return answer;
    }

    public int[][] kClosest1(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> sqPow(p1).compareTo(sqPow(p2)));
        var answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            answer[i] = points[i];
        }
        return answer;
    }

    public Integer sqPow(int[] coord) {
        return coord[0] * coord[0] + coord[1] * coord[1];
    }
}
