package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class Task1774 {

    @Test
    void example1() {
        var baseCosts = new int[]{3, 10};
        var toppingCosts = new int[]{2, 5};
        var target = 9;
        Assertions.assertEquals(8, closestCost(baseCosts, toppingCosts, target));
    }

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        var variants = new ArrayList<Integer>();
        variants.add(0);
        var answer = Integer.MAX_VALUE;
        for (int toppingCost : toppingCosts) {
            var size = variants.size();
            for (int i = 0; i < size; i++) {
                variants.add(variants.get(i) + toppingCost);
                variants.add(variants.get(i) + toppingCost * 2);
            }
        }
        for (int baseCost : baseCosts) {
            var size = variants.size();
            for (int i = 0; i < size; i++) {
                var cost = baseCost + variants.get(i);
                if (Math.abs(target - cost) < Math.abs(target - answer)) {
                    answer = cost;
                } else if (Math.abs(target - cost) == Math.abs(target - answer) && cost < answer) {
                    answer = cost;
                }
            }
        }

        return answer;
    }

}
