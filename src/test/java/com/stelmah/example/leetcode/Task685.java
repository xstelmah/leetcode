
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;


class Task685 {


    @Test
    void example1() {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        int[] expected = {4, 1};


        int[] response = findRedundantDirectedConnection(edges);
        Assertions.assertArrayEquals(expected, response);
    }

    @Test
    void example2() {
        int[][] edges = {{2, 1}, {3, 1}, {4, 2}, {1, 4}};
        int[] expected = {2, 1};


        int[] response = findRedundantDirectedConnection(edges);
        Assertions.assertArrayEquals(expected, response);
    }

    @Test
    void example3() {
        int[][] edges = {{3, 1}, {2, 1}, {4, 2}, {1, 4}};
        int[] expected = {2, 1};


        int[] response = findRedundantDirectedConnection(edges);
        Assertions.assertArrayEquals(expected, response);
    }

    @Test
    void example4() {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] expected = {2, 3};

        int[] response = findRedundantDirectedConnection(edges);
        Assertions.assertArrayEquals(expected, response);
    }

    @Test
    void example5() {
        int[][] edges = {{1, 2}, {2, 3}, {1, 3}};
        int[] expected = {1, 3};

        int[] response = findRedundantDirectedConnection(edges);
        Assertions.assertArrayEquals(expected, response);
    }

    @Test
    void example6() {
        int[][] edges = {{1, 2}, {2, 3}, {3, 1}, {4, 1}};
        int[] expected = {3, 1};

        int[] response = findRedundantDirectedConnection(edges);
        Assertions.assertArrayEquals(expected, response);
    }

    @Test
    void example7() {

        int[][] edges = {{5, 2}, {5, 1}, {3, 1}, {3, 4}, {3, 5}};
        int[] expected = {3, 1};

        int[] response = findRedundantDirectedConnection(edges);
        Assertions.assertArrayEquals(expected, response);
    }

    @Test
    void example8() {

        int[][] edges = {{7, 2}, {10, 1}, {2, 3}, {3, 5}, {10, 6}, {4, 6}, {10, 9}, {2, 4}, {7, 10}, {3, 8}};
        int[] expected = {4, 6};

        int[] response = findRedundantDirectedConnection(edges);
        Assertions.assertArrayEquals(expected, response);
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        var n = edges.length + 1;
        int[] nodes = new int[n];
        var mp = new HashMap<Integer, Integer>();
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = i;
        }
        int[] p1 = null;
        int[] p2 = null;

        for (var edge : edges) {
            if (mp.containsKey(edge[1])) {
                p2 = new int[]{edge[0], edge[1]};
                p1 = new int[]{mp.get(edge[1]), edge[1]};
                edge[0] = 0;
                break;
            }
            mp.put(edge[1], edge[0]);
        }

        for (var edge : edges) {
            if (edge[0] == 0) {
                continue;
            }
            if (isConnected(nodes, edge[0], edge[1])) {
                if (p1 == null) {
                    return new int[]{edge[0], edge[1]};
                }

            }
            union(nodes, edge[0], edge[1]);
        }
        var r = root(nodes, 1);
        for (int i = 2; i < n; i++) {
            if (root(nodes, i) != r) {
                return p1;
            }
        }
        return p2;
    }

    public void union(int[] nodes, int n1, int n2) {
        var r1 = root(nodes, n1);
        var r2 = root(nodes, n2);

        nodes[r2] = r1;
    }

    public int root(int[] nodes, int index) {
        if (index == nodes[index]) {
            return index;
        }
        return nodes[index] = root(nodes, nodes[index]);
    }

    public boolean isConnected(int[] nodes, int n1, int n2) {
        return root(nodes, n1) == root(nodes, n2);
    }
}
