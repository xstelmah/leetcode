package com.stelmah.example.leetcode;

import com.stelmah.example.leetcode.util.AssertionUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Task73 {

    @Test
    void example1() {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] expected = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
        setZeroes(matrix);
        AssertionUtils.assertMatrixEquals(expected, matrix);
    }

    public void setZeroes(int[][] matrix) {
        int zRow = -1;
        int zColumn = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] == 0) {
                    if (zRow == -1) {
                        zRow = row;
                        zColumn = column;
                    } else {
                        matrix[zRow][column] = 0;
                        matrix[row][zColumn] = 0;
                    }
                }
            }
        }

        if (zRow == -1) {
            return;
        }

        for (int column = 0; column < matrix[0].length; column++) {
            if (column != zColumn && matrix[zRow][column] == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][column] = 0;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][zColumn] == 0) {
                Arrays.fill(matrix[row], 0);
            }
            matrix[row][zColumn] = 0;
        }
    }

}
