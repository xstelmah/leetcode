package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task72 {
    @Test
    void example2() {
        var word1 = "horse";
        var word2 = "ros";
        Assertions.assertEquals(3, minDistance(word1, word2));
    }
    @Test
    void example3() {
        var word1 = "";
        var word2 = "";
        Assertions.assertEquals(0, minDistance(word1, word2));
    }
    @Test
    void example4() {
        var word1 = "";
        var word2 = "a";
        Assertions.assertEquals(1, minDistance(word1, word2));
    }
    @Test
    void example5() {
        var word1 = "a";
        var word2 = "ab";
        Assertions.assertEquals(1, minDistance(word1, word2));
    }
    @Test
    void example6() {
        var word1 = "ab";
        var word2 = "a";
        Assertions.assertEquals(1, minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        var rows = word1.length();
        var columns = word2.length();
        var dp = new int[rows + 1][columns + 1];
        for (int row = 1; row <= rows; row++) {
            dp[row][0] = row;
        }
        for (int column = 1; column <= columns; column++) {
            dp[0][column] = column;
        }
        for (int row = 1; row <= rows; row++) {
            for (int column = 1; column <= columns; column++) {
                if (word1.charAt(row - 1) == word2.charAt(column - 1)) {
                    dp[row][column] = dp[row - 1][column - 1];
                } else {
                    dp[row][column] = 1 + Math.min(
                            dp[row - 1][column - 1],
                            Math.min(dp[row - 1][column], dp[row][column - 1])
                    );
                }
            }
        }
        return dp[rows][columns];
    }

}
