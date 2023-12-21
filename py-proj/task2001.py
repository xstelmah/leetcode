import collections
import math
from typing import List


class Solution:
    def interchangeableRectangles(self, rectangles: List[List[int]]) -> int:
        m = collections.defaultdict(int)

        for rect in rectangles:
            gcd = math.gcd(rect[0], rect[1])
            m[(rect[0] // gcd, rect[1] // gcd)] += 1

        answer = 0
        for v in m.values():
            answer += (v * (v - 1)) // 2
        return answer


s = Solution()
print(s.interchangeableRectangles([[4, 8], [3, 6], [10, 20], [15, 30]]) == 6)

print(s.interchangeableRectangles([[4, 8], [3, 6], [10, 20], [15, 30]]))
print(s.interchangeableRectangles([[4, 5], [7, 8]]) == 0)
