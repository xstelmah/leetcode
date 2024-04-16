
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task1594 {


    @Test
    void example1() {
        int[][] grid = {{1, -2, 1}, {1, -2, 1}, {3, -4, 1}};
        Assertions.assertEquals(8, maxProductPath(grid));
    }

    public int maxProductPath(int[][] grid) {
        var n = grid.length;
        var m = grid[0].length;
        var dp = new Long[n][m][2];// 0 - max, 1 - min
        int[][] shifts = {{-1, 0}, {0, -1}};

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                for (var shift : shifts) {
                    if (row + shift[0] < 0 || col + shift[1] < 0) {
                        continue;
                    }
                    var cell = dp[row + shift[0]][col + shift[1]];
                    if (grid[row][col] <= 0) {
                        var pos = cell[0];
                        var neg = cell[1];
                        if (pos != null) {
                            dp[row][col][1] = (dp[row][col][1] == null ? pos * grid[row][col] : Math.min(dp[row][col][1], pos * grid[row][col]));
                        }
                        if (neg != null) {
                            dp[row][col][0] = (dp[row][col][0] == null ? neg * grid[row][col] : Math.max(dp[row][col][0], neg * grid[row][col]));
                        }
                    }
                    if (grid[row][col] >= 0) {
                        var pos = cell[0];
                        var neg = cell[1];
                        if (pos != null) {
                            dp[row][col][0] = (dp[row][col][0] == null ? pos * grid[row][col] : Math.max(dp[row][col][0], pos * grid[row][col]));
                        }
                        if (neg != null) {
                            dp[row][col][1] = (dp[row][col][1] == null ? neg * grid[row][col] : Math.min(dp[row][col][1], neg * grid[row][col]));
                        }
                    }
                }
                if (dp[row][col][0] == null && dp[row][col][1] == null) {
                    if (grid[row][col] <= 0) {
                        dp[row][col][1] = (long) grid[row][col];
                    }

                    if (grid[row][col] >= 0) {
                        dp[row][col][0] = (long) grid[row][col];
                    }
                }
            }
        }
        return dp[n - 1][m - 1][0] == null ? -1 : (int) (dp[n - 1][m - 1][0] % 1_000_000_007);
    }

}
