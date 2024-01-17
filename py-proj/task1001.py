import collections
from typing import List


class Solution:
    def gridIllumination(self, n: int, lamps: List[List[int]], queries: List[List[int]]) -> List[int]:
        diag1 = collections.defaultdict(int)
        diag2 = collections.defaultdict(int)
        rows = collections.defaultdict(int)
        columns = collections.defaultdict(int)
        points = collections.defaultdict(int)
        positions = [[-1, -1], [1, 1], [1, -1], [-1, 1], [0, 1], [1, 0], [-1, 0], [0, -1], [0, 0]]
        answers = []
        for y, x in lamps:
            diag1[x - y] += 1
            diag2[x + y] += 1
            rows[y] += 1
            columns[x] += 1
            points[y, x] += 1

        for y, x in queries:
            if rows[y] or columns[x] or diag1[x - y] or diag2[x + y]:
                answers.append(1)
                for y1, x1 in positions:
                    newY = y + y1
                    newX = x + x1
                    if points[newY, newX]:
                        diag1[newX - newY] -= points[newY, newX]
                        diag2[newX + newY] -= points[newY, newX]
                        rows[newY] -= points[newY, newX]
                        columns[newX] -= points[newY, newX]
                        points[newY, newX] -= points[newY, newX]

            else:
                answers.append(0)
        return answers


s = Solution()
print(s.gridIllumination(5, [[0, 0], [4, 4]], [[1, 1], [1, 1]]) == [1, 1])
print(s.gridIllumination(n=5, lamps=[[0, 0], [0, 4]], queries=[[0, 4], [0, 1], [1, 4]]) == [1, 1, 0])
print(s.gridIllumination(n=6, lamps=[[2, 5], [4, 2], [0, 3], [0, 5], [1, 4], [4, 2], [3, 3], [1, 0]],
                         queries=[[4, 3], [3, 1], [5, 3], [0, 5], [4, 4], [3, 3]]) == [1, 0, 1, 1, 0, 1]
      )
# print(s.gridIllumination(n=6, lamps=[[2, 5], [4, 2], [0, 3], [0, 5], [1, 4], [4, 2], [3, 3], [1, 0]],
#                          queries=[[4, 3], [3, 1], [5, 3], [0, 5], [4, 4], [3, 3]])
#       )
