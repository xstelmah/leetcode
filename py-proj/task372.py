import math
from typing import List


class Solution:
    modulo = 1337

    def superPow(self, a: int, b: List[int]) -> int:
        if not len(b):
            return 1
        digit = b.pop()
        a %= self.modulo

        return (self.superPow(self.pow(a, 10), b) * self.pow(a, digit)) % self.modulo

    def pow(self, a: int, b: int) -> int:
        result = 1
        for i in range(b):
            result = (result * a) % self.modulo
        return result


s = Solution()

print(s.superPow(1024, [1, 0]) == (1024 ** 10 % 1337))
print(s.superPow(1024, [1, 0]))
