package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task199 {

    @Test
    void example1() {
        var root = TreeNode.fromSimplifiedArray(new Integer[]{1, 2, 3, null, 5, null, 4});
        var response = rightSideView(root);
        Integer[] args = {1, 3, 4};

        Assertions.assertEquals(3, response.size());
        Assertions.assertArrayEquals(args, response.toArray());
    }
    @Test
    void example2() {
        var root = TreeNode.fromSimplifiedArray(new Integer[]{1, 2, null});
        var response = rightSideView(root);
        Integer[] args = {1, 2};

        Assertions.assertEquals(2, response.size());
        Assertions.assertArrayEquals(args, response.toArray());
    }


    /**
     * Beats 100%.
     */
    public List<Integer> rightSideView(TreeNode root) {
        var list = new ArrayList<Integer>();
        rightSideView(root, list, 0);

        return list;
    }


    public void rightSideView(TreeNode root, List<Integer> list, int h) {
        if (root == null) {
            return;
        }
        if (list.size() == h) {
            list.add(root.val);
        }
        rightSideView(root.right, list, h + 1);
        rightSideView(root.left, list, h + 1);
    }
}