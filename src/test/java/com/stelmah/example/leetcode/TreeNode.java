package com.stelmah.example.leetcode;

public class TreeNode {
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

    public static TreeNode fromSimplifiedArray(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        var nodeArray = new TreeNode[array.length];
        for (int i = 0; i < nodeArray.length; i++) {
            if (array[i] == null) {
                continue;
            }
            nodeArray[i] = new TreeNode(array[i]);
        }
        var left = 0;
        var right = 0;
        while (left < nodeArray.length) {
            var notEmptyCount = 0;
            var totalCount = 0;
            for (int index = left; index <= right && index < nodeArray.length; index++) {
                if (nodeArray[index] != null) {
                    notEmptyCount++;
                }
                totalCount++;
            }
            for (int j = 0, i = 0; j < totalCount; j++) {
                if (left + j > nodeArray.length) {
                    break;
                }
                if (nodeArray[left + j] == null) {
                    continue;
                }
                if (left + totalCount + i * 2 < nodeArray.length) {
                    nodeArray[left + j].left = nodeArray[left + totalCount + i * 2];
                }
                if (left + totalCount + i * 2 + 1 < nodeArray.length) {
                    nodeArray[left + j].right = nodeArray[left + totalCount + i * 2 + 1];
                }
                i++;
            }
            left = right + 1;
            right = left + notEmptyCount * 2 - 1;
        }
        return nodeArray[0];
    }
}
