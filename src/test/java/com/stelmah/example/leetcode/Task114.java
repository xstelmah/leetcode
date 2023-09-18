package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task114 {

    @Test
    void example1() {
        // tree in array root = [1,2,5,3,4,null,6]
        var treeNode = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6)));
        flatten(treeNode);

        System.out.println(treeNode);
    }

    @Test
    void example2() {
        // tree in array root = [0,1,4,2,3]
        var treeNode = new TreeNode(0,
                new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                new TreeNode(4));
        flatten(treeNode);

        System.out.println(treeNode);
    }
    TreeNode current = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        current = root;
        var left = root.left;
        var right = root.right;
        if (left != null) {
            current.right = left;
            current.left = null;
            current = current.right;
            flatten(left);
        }
        if (right != null) {
            current.right = right;
            current.left = null;
            current = current.right;
           flatten(right);
        }
    }

    /*

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        current = root;
        var left = root.left;
        var right = root.right;
        if (left != null) {
            root.right = left;
            flatten(left);
            root.left = null;
        }
        if (right != null) {
           if (root.right != null) {
               root.right.right = right;
           } else {
               root.right = right;
           }
           flatten(right);
        }

    }

     */


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
