import math
from typing import List

_max = 10 ** 6 + 1

primes = [i & 1 for i in range(_max)]

primes[1] = 0
primes[2] = 1
for i in range(3, int(math.sqrt(_max)) + 1, 2):
    if primes[i] == 1:
        for j in range(i * 2, _max, i):
            primes[j] = 0


class Solution:
    def findPrimePairs(self, n: int) -> List[List[int]]:
        if n == 1: return []

        answer = []
        num = 2
        while num <= n // 2:
            if primes[num] and primes[n - num]:
                answer.append([num, n - num])
            if num == 2:
                num += 1
            else:
                num += 2
        return answer


s = Solution()
# print(s.findPrimePairs(100000))
print(s.findPrimePairs(1) == [])
print(s.findPrimePairs(2) == [])
print(s.findPrimePairs(3) == [])
print(s.findPrimePairs(10) == [[3, 7], [5, 5]])
