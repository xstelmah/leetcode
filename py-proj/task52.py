from typing import List


class Solution:
    def totalNQueens(self, n: int) -> int:
        m = [[0 for _ in range(n)] for _ in range(n)]
        steps = [[-1, -1], [1, 1], [1, -1], [-1, 1], [0, 1], [1, 0], [-1, 0], [0, -1]]

        answer = [0]
        def solve(row: int):
            for index in range(n):
                if m[row][index] == 0:
                    fillQueenSteps(row, index, 1)
                    if row == n - 1:
                        answer[0] += 1
                    else:
                        solve(row + 1)
                    fillQueenSteps(row, index, -1)

        def fillQueenSteps(row: int, column: int, order: int):
            m[row][column] += order
            for step in steps:
                tempRow = row + step[0]
                tempColumn = column + step[1]
                while tempRow >= 0 and tempColumn >= 0 and tempRow < n and tempColumn < n:
                    m[tempRow][tempColumn] += order
                    tempRow = tempRow + step[0]
                    tempColumn = tempColumn + step[1]


        solve(0)

        return answer[0]


s = Solution()
print(s.totalNQueens(4) == 2)
print(s.totalNQueens(9))
