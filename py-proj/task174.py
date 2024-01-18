from typing import List


class Solution:
    def calculateMinimumHP(self, dungeon: List[List[int]]) -> int:
        n = len(dungeon)
        m = len(dungeon[0])
        dp = [[(0, 0) for _ in range(m)] for _ in range(n)]

        dp[-1][-1] = dungeon[-1][-1] if dungeon[-1][-1] <= 0 else 0
        for i in range(n - 1, -1, -1):
            for j in range(m - 1, -1, -1):
                if i == n - 1 and j == m - 1:
                    continue
                if i == n - 1:
                    dp[i][j] = dp[i][j + 1] + dungeon[i][j]
                elif j == m - 1:
                    dp[i][j] = dp[i + 1][j] + dungeon[i][j]
                else:
                    right = dp[i][j + 1] + dungeon[i][j]
                    bottom = dp[i + 1][j] + dungeon[i][j]
                    if right > bottom:
                        dp[i][j] = right
                    else:
                        dp[i][j] = bottom
                if dp[i][j] >= 0:
                    dp[i][j] = 0
        return -dp[0][0] + 1 if dp[0][0] < 0 else 1


s = Solution()

print(s.calculateMinimumHP([[-2, -3, 3], [-5, -10, 1], [10, 30, -5]]) == 7)
# print(s.calculateMinimumHP([[-2, -3, 3], [-5, -10, 1], [10, 30, -5]]))
print(s.calculateMinimumHP([[1, -3, 3], [0, -2, 0], [-3, -3, -3]]) == 3)
print(s.calculateMinimumHP([[-3, 5]]) == 4)
# print(s.calculateMinimumHP([[-3, 5]]))
print(s.calculateMinimumHP([[1, 2, 1], [-2, -3, -3], [3, 2, -2]]) == 1)
# print(s.calculateMinimumHP([[1, 2, 1], [-2, -3, -3], [3, 2, -2]]))
# print(s.calculateMinimumHP([[1, -3, 3], [0, -2, 0], [-3, -3, -3]]))
