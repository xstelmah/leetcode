package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class Task437_2 {

    @Test
    void example1() {
        // tree in array [10,5,-3,3,2,null,11,3,-2,null,1]
        var treeNode = new TreeNode(10,
                new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11)));
        var response = pathSum(treeNode, 8);
        Assertions.assertEquals(3, response);

    }
    @Test
    void example2() {
        // tree in array [1,null,-1,null,1,null,-1,null,1, null, -1]
        var treeNode = new TreeNode(1,
                null,
                new TreeNode(-1,
                        null,
                        new TreeNode(1,
                                null,
                                new TreeNode(-1,
                                        null,
                                        new TreeNode(1,
                                                null,
                                                new TreeNode(-1))))));
        var response = pathSum(treeNode, 0);
        Assertions.assertEquals(9, response);

    }

    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        helper(root, 0, sum, preSum);
        return count;
    }
    int count = 0;
    public void helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return;
        }

        currSum += root.val;

        if (preSum.containsKey(currSum - target)) {
            count += preSum.get(currSum - target);
        }

        if (!preSum.containsKey(currSum)) {
            preSum.put(currSum, 1);
        } else {
            preSum.put(currSum, preSum.get(currSum)+1);
        }

        helper(root.left, currSum, target, preSum);
        helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
