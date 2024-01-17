import collections
import math


class Solution:

    def distinctSequences(self, n: int) -> int:
        if n == 1: return 6
        if n == 2: return 22
        pairs = [[0 for _ in range(7)] for _ in range(7)]
        newPairs = [[0 for _ in range(7)] for _ in range(7)]
        combinations = [[] for _ in range(7)]
        for i in range(1, 7):
            for j in range(1, 7):
                if i != j and math.gcd(i, j) == 1:
                    pairs[i][j] = 1
                    combinations[i].append(j)
        n -= 2
        answer = 0
        while n > 0:
            for k1 in range(1, 7):
                for k2 in range(1, 7):
                    newPairs[k1][k2] = 0

            for k1 in range(1, 7):
                for k2 in range(1, 7):
                    if not pairs[k1][k2]:
                        continue
                    for possible in combinations[k2]:
                        if k1 != possible:
                            newPairs[k2][possible] += pairs[k1][k2]
            n -= 1
            for k1 in range(1, 7):
                for k2 in range(1, 7):
                    pairs[k1][k2] = newPairs[k1][k2]

            if n == 0:
                for row in pairs:
                    for num in row:
                        answer = (answer + num) % 1_000_000_007
        return answer


s = Solution()
print(s.distinctSequences(1) == 6)
print(s.distinctSequences(2) == 22)
print(s.distinctSequences(3) == 66)
print(s.distinctSequences(4) == 184)
print(s.distinctSequences(5) == 516)
