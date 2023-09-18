package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task437 {

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
        // tree in array [1,null,2,null,3,null,4,null,5]
        var treeNode = new TreeNode(1,
                null,
                new TreeNode(2,
                        null,
                        new TreeNode(3,
                                null,
                                new TreeNode(4,
                                        null,
                                        new TreeNode(5)))));
        var response = pathSum(treeNode, 3);
        Assertions.assertEquals(2, response);

    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
       return pathSum(root, 0, targetSum, false);
    }

    public int pathSum(TreeNode root, long current, int targetSum, boolean took) {
        var answer = 0;
        if (current + root.val == targetSum) {
            answer++;
        }
        if (root.left != null) {
            answer += pathSum(root.left, current + root.val, targetSum, true);
            if (!took) {
                answer += pathSum(root.left, 0, targetSum, false);
            }
        }
        if (root.right != null) {
            answer += pathSum(root.right, current + root.val, targetSum, true);
            if (!took) {
                answer += pathSum(root.right, 0, targetSum, false);
            }
        }
        return answer;
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
