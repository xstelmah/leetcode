import math
from typing import List


class Solution:
    def numberOfWeeks(self, milestones: List[int]) -> int:
        max = 0
        sum = 0
        for val in milestones:
            if val > max:
                max = val
            sum += val
        if sum - max >= max:
            return sum
        return 2 * (sum - max) + 1


s = Solution()
print(s.numberOfWeeks([5, 2, 1]))
print(s.numberOfWeeks([5, 2, 1]) == 7)
print(s.numberOfWeeks([1, 2, 3]) == 6)
print(s.numberOfWeeks([5, 1, 1]) == 5)
