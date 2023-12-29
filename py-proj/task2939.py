from typing import List


class Solution:
    def maximumXorProduct(self, a: int, b: int, n: int) -> int:
        answer = a * b
        for shift in range(n - 1, -1, -1):
            newA = a ^ (1 << shift)
            newB = b ^ (1 << shift)
            if newA * newB > answer:
                answer = newA * newB
                a = newA
                b = newB
        return answer % (10 ** 9 + 7)


s = Solution()
print(s.maximumXorProduct(12, 5, 4) == 98)
print(s.maximumXorProduct(12, 5, 4))
print(s.maximumXorProduct(1, 6, 3) == 12)
