package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task89 {

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
        if (n == 1) {
            return List.of(0, 1);
        }
        var list = new ArrayList<Integer>(1 << n);
        list.addAll(List.of(0, 1, 3, 2));
        var pow = 2;
        for (int i = 2; i < n; i++) {
            pow <<= 1;
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(list.get(j) + pow);
            }
        }
        return list;
    }

}
