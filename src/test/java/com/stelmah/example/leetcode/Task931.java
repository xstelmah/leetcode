
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task931 {

    @Test
    void example1() {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        Assertions.assertEquals(13, minFallingPathSum(matrix));
    }


    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }

        var n = matrix.length;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n - 1; j++) {
                matrix[i][j] += Math.min(
                        matrix[i - 1][j - 1],
                        Math.min(matrix[i - 1][j], matrix[i - 1][j + 1])
                );
            }
            matrix[i][0] += Math.min(matrix[i - 1][0], matrix[i - 1][1]);
            matrix[i][n - 1] += Math.min(matrix[i - 1][n - 1], matrix[i - 1][n - 2]);
        }


        var min = 10001;
        for (int i = 0; i < n; i++) {
            if (min > matrix[n - 1][i]) {
                min = matrix[n - 1][i];
            }
        }
        return min;
    }
}
