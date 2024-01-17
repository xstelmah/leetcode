from typing import List


class Solution:
    def uniquePathsWithObstacles(self, dp: List[List[int]]) -> int:
        if dp[0][0] == 1:
            return 0
        for row in range(len(dp)):
            for column in range(len(dp[row])):
                if dp[row][column] == 1:
                    dp[row][column] = -1
                    continue
                if row == 0 and column == 0:
                    dp[0][0] = 1
                    continue
                if column > 0 and dp[row][column - 1] != -1:
                    dp[row][column] += dp[row][column - 1]
                if row > 0 and dp[row - 1][column] != -1:
                    dp[row][column] += dp[row - 1][column]

        return max(0, dp[-1][-1])


s = Solution()
print(s.uniquePathsWithObstacles([[0, 0, 0], [0, 1, 0], [0, 0, 0]]) == 2)
print(s.uniquePathsWithObstacles([[1, 0]]) == 0)
