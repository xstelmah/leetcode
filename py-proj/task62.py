class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for _ in range(m)] for _ in range(n)]
        dp[0][0] = 1
        for row in range(n):
            for column in range(m):
                if row == 0 and column == 0:
                    continue
                if row > 0:
                    dp[row][column] += dp[row - 1][column]
                if column > 0:
                    dp[row][column] += dp[row][column - 1]
        return dp[n - 1][m - 1]


s = Solution()
print(s.uniquePaths(3, 7) == 28)
