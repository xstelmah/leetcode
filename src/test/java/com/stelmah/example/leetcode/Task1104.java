package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class Task1104 {

    @Test
    void example1() {
        var label = 26;
        var response = pathInZigZagTree(label);
        Assertions.assertArrayEquals(List.of(1, 2, 6, 10, 26).toArray(), response.toArray());
    }

    @Test
    void example2() {
        var label = 14;
        var response = pathInZigZagTree(label);
        Assertions.assertArrayEquals(List.of(1, 3, 4, 14).toArray(), response.toArray());
    }
    @Test
    void example3() {
        var label = 1;
        var response = pathInZigZagTree(label);
        Assertions.assertArrayEquals(List.of(1).toArray(), response.toArray());
    }
    @Test
    void example4() {
        var label = 3;
        var response = pathInZigZagTree(label);
        Assertions.assertArrayEquals(List.of(1, 3).toArray(), response.toArray());
    }

    public List<Integer> pathInZigZagTree(int label) {
        int pow2 = findParentLimit(label);
        var result = new ArrayList<Integer>();

        fillPath(label, pow2, result);

        return result;
    }


    private void fillPath(int label, int pow2, List<Integer> result) {
        if (label == 1) {
            result.add(label);
            return;
        }

        // pow2 - 1 == previous level max element
        // pow2 / 2 == previous level min element
        // label / 2 == our position on previous level in normal tree
        fillPath(pow2 - 1 - label / 2 + pow2 / 2, pow2 / 2, result);

        result.add(label);
    }

    private int findParentLimit(int label) {
        var pow2 = 1;
        while (label > 1) {
            label /= 2;
            pow2 <<= 1;
        }
        return pow2;
    }


}
