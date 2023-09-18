package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task113 {

    @Test
    void example1() {
        // tree in array [5,4,8,11,null,13,4,7,2,null,null,5,1]
        var treeNode = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        var response = pathSum(treeNode, 22);
        Assertions.assertEquals(2, response.size());

    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        var response = new ArrayList<List<Integer>>();
        pathSum(root, targetSum, new ArrayList<>(), response);
        return response;
    }

    public void pathSum(TreeNode root, int targetSum, List<Integer> current, List<List<Integer>> response) {
        if (root == null) {
            return;
        }
        current.add(root.val);
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            response.add(new ArrayList<>(current));
        }
        if (root.left != null) {
            pathSum(root.left, targetSum - root.val, current, response);
        }
        if (root.right != null) {
            pathSum(root.right, targetSum - root.val, current, response);
        }
        current.remove(current.size() - 1);
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
