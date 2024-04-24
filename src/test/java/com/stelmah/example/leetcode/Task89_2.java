package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task89_2 {

    @Test
    void example1() {
        int n = 2;

        var expected = List.of(0, 1, 3, 2);
        Assertions.assertArrayEquals(expected.toArray(), grayCode(n).toArray());
    }

    @Test
    void example2() {
        int n = 3;

        var expected = List.of(0, 1, 3, 2, 6, 7, 5, 4);
        Assertions.assertArrayEquals(expected.toArray(), grayCode(n).toArray());
    }

    public List<Integer> grayCode(int n) {
        var list = new ArrayList<Integer>(1 << n);
        list.add(0);
        var len = 1 << n;
        for (int i = 1; i < len; i++) {
            list.add(i ^ i >> 1);
        }
        return list;
    }

}
