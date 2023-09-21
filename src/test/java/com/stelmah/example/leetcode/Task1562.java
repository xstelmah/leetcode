package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1562 {

    @Test
    void example1() {
        var arr = new int[]{3, 5, 1, 2, 4};
        var k = 1;
        Assertions.assertEquals(4, findLatestStep(arr, k));
    }

    @Test
    void example2() {
        var arr = new int[]{3, 1, 5, 4, 2};
        var k = 2;
        Assertions.assertEquals(-1, findLatestStep(arr, k));
    }

    public int findLatestStep(int[] arr, int m) {
        var answer = -1;
        var sizeGroups = new int[arr.length + 1];
        var nodeGroups = new Node[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            var pos = arr[i] - 1;
            var leftNode = (pos > 0) ? nodeGroups[pos - 1] : null;
            var rightNode = (pos != arr.length - 1) ? nodeGroups[pos + 1] : null;
            if (leftNode != null && rightNode != null) {
                sizeGroups[leftNode.count]--;
                sizeGroups[rightNode.count]--;
                Node targetNode = null;
                if (leftNode.count > rightNode.count) {
                    targetNode = leftNode;
                    targetNode.count += rightNode.count + 1;
                    targetNode.rightIndex = rightNode.rightIndex;
                } else {
                    targetNode = rightNode;
                    targetNode.count += leftNode.count + 1;
                    targetNode.leftIndex = leftNode.leftIndex;
                }
                for (int j = targetNode.leftIndex; j <= targetNode.rightIndex; j++) {
                    nodeGroups[j] = targetNode;
                }
                nodeGroups[pos] = targetNode;
                sizeGroups[targetNode.count]++;
            } else if (leftNode != null) {
                sizeGroups[leftNode.count++]--;
                sizeGroups[leftNode.count]++;
                nodeGroups[pos] = leftNode;
                leftNode.rightIndex = pos;
            } else if (rightNode != null) {
                sizeGroups[rightNode.count++]--;
                sizeGroups[rightNode.count]++;
                nodeGroups[pos] = rightNode;
                rightNode.leftIndex = pos;
            } else {
                var node = new Node(1, pos, pos);
                sizeGroups[node.count]++;
                nodeGroups[pos] = node;
            }

            if (sizeGroups[m] > 0) {
                answer = i + 1;
            }
        }
        return answer;
    }

    public static class Node {

        public int count;
        public int leftIndex;
        public int rightIndex;

        public Node(int count, int leftIndex, int rightIndex) {
            this.count = count;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }
    }
}