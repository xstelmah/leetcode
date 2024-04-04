
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Task1627 {


    @Test
    void example1() {
        var n = 16;
        var threshold = 7;
        int[][] queries = {{12, 16}, {8, 3}, {9, 15}, {13, 16}, {4, 12}, {5, 7}, {15, 4}, {16, 1}, {14, 4}, {6, 15}, {7, 9}, {3, 5}, {11, 9}, {2, 4}, {3, 15}, {8, 15}, {14, 11}, {1, 3}, {3, 4}, {10, 14}, {11, 5}, {6, 1}, {13, 14}, {14, 15}, {13, 5}, {9, 10}, {8, 11}, {7, 3}, {11, 6}, {1, 11}, {15, 13}, {12, 5}, {12, 14}, {12, 13}, {8, 1}, {3, 12}, {15, 1}, {9, 13}, {10, 2}, {1, 13}, {8, 6}, {5, 6}, {6, 14}, {13, 8}, {16, 10}, {12, 7}, {16, 5}, {5, 4}, {2, 3}, {2, 15}, {15, 11}, {8, 9}, {9, 14}, {10, 4}, {13, 4}, {1, 2}, {11, 7}, {9, 6}, {8, 7}, {16, 6}, {15, 7}, {14, 16}, {3, 6}, {4, 16}, {1, 4}, {2, 14}, {5, 15}, {11, 12}, {1, 14}, {4, 8}, {8, 5}, {1, 10}, {10, 3}, {10, 13}, {4, 6}, {9, 12}, {12, 8}, {14, 8}, {10, 15}, {16, 8}, {15, 16}, {14, 3}, {4, 11}, {11, 10}};
        Boolean[] expected = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false};


        Boolean[] response = areConnected(n, threshold, queries).toArray(new Boolean[0]);
        Assertions.assertArrayEquals(expected, response);
    }

    @Test
    void example2() {
        var n = 14;
        var threshold = 4;
        int[][] queries = {{4, 2}, {7, 2}, {4, 3}, {1, 4}, {4, 11}, {6, 8}, {8, 12}, {12, 5}, {3, 7}, {12, 6}, {3, 6}, {11, 9}, {6, 9}, {6, 4}, {4, 9}, {14, 4}, {10, 14}, {14, 2}, {9, 8}, {8, 7}, {13, 14}, {12, 4}, {7, 4}, {10, 4}, {1, 6}, {9, 7}, {5, 13}, {10, 11}, {14, 8}, {5, 6}, {7, 12}, {11, 5}, {8, 13}, {4, 8}, {1, 9}, {8, 2}, {1, 13}, {5, 9}, {12, 1}, {13, 10}, {1, 8}, {10, 6}, {9, 13}, {6, 11}, {3, 5}, {5, 2}};
        Boolean[] expected = {false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};


        Boolean[] response = areConnected(n, threshold, queries).toArray(new Boolean[0]);
        Assertions.assertArrayEquals(expected, response);
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        if (threshold == 0) {
            return Stream.generate(() -> Boolean.TRUE).limit(queries.length).collect(Collectors.toList());
        }
        var nodes = new int[n + 1];
        var sizes = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = i;
            sizes[i] = 1;
        }
        var halfN = n / 2;

        for (int i = threshold + 1; i <= halfN; i++) {
            int j = 2;
            while (i * j <= n) {
                union(nodes, sizes, i, i * j);
                j++;
            }
        }
        var response = new ArrayList<Boolean>(queries.length);
        for (var query : queries) {
            response.add(isConnected(nodes, query[0], query[1]));
        }
        return response;
    }

    public void union(int[] nodes, int[] sizes, int num1, int num2) {
        var root1 = root(nodes, num1);
        var root2 = root(nodes, num2);

        if (sizes[root1] > sizes[root2]) {
            nodes[root2] = root1;
            sizes[root1] += sizes[root2];
        } else {
            nodes[root1] = root2;
            sizes[root2] += sizes[root1];
        }
    }

    public int root(int[] nodes, int num) {
        while (num != nodes[num]) {
            nodes[num] = nodes[nodes[num]];
            num = nodes[num];
        }
        return num;
    }

    public Boolean isConnected(int[] nodes, int num1, int num2) {
        return root(nodes, num1) == root(nodes, num2);
    }
}
