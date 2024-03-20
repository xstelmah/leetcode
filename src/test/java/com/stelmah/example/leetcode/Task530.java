package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class Task530 {

    @Test
    void example1() {
        var tree = TreeNode.fromSimplifiedArray(new Integer[]{1, 0, 48, null, null, 12, 49});
        var response = getMinimumDifference(tree);
        Assertions.assertEquals(1, response);
    }

    @Test
    void example2() {

        var tree = TreeNode.fromSimplifiedArray(new Integer[]{4, 2, 6, 1, 3});
        var response = getMinimumDifference(tree);
        Assertions.assertEquals(1, response);
    }

    @Test
    void example3() {

        var tree = TreeNode.fromSimplifiedArray(new Integer[]{236, 104, 701, null, 227, null, 911});
        var response = getMinimumDifference(tree);
        Assertions.assertEquals(9, response);
    }

    public int getMinimumDifference(TreeNode root) {
        var nodes = new ArrayList<Integer>();
        mapToList(root, nodes);
        nodes.sort(Integer::compareTo);
        var result = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.size() - 1; i++) {
            result = Math.min(result, Math.abs(nodes.get(i) - nodes.get(i + 1)));
        }
        return result;
    }

    private void mapToList(TreeNode node, List<Integer> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(node.val);
        mapToList(node.left, nodes);
        mapToList(node.right, nodes);
    }

}
