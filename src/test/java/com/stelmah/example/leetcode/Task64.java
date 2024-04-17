package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task64 {
    @Test
    void example2() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Assertions.assertEquals(7, minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        var rows = grid.length;
        var columns = grid[0].length;
        var dp = new int [rows][columns];
        dp[0][0] = grid[0][0];
        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row - 1][0] + grid[row][0];
        }
        for (int column = 1; column < columns; column++) {
            dp[0][column] = dp[0][column - 1] + grid[0][column];
        }
        for(int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                dp[row][column] = grid[row][column] + Math.min(
                        dp[row - 1][column],
                        dp[row][column - 1]
                );
            }
        }
        return dp[rows - 1][columns - 1];
    }



}
