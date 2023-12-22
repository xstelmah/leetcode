import numbers
import sys
from typing import List


class Solution:
    def minimalKSum(self, nums: List[int], k: int) -> int:
        nums.append(0xFFFFFFFF)
        nums = sorted(nums)
        result = 0
        left = 1
        for num in nums:
            if num > left and k > 0:
                range = num - left
                expRange = min(k, range)
                k -= expRange
                right = left + expRange - 1
                result += right * (right + 1) // 2 - left * (left + 1) // 2 + left
            left = num + 1

        return result


s = Solution()
print(s.minimalKSum([5, 6], 6) == 25)
print(s.minimalKSum([1, 4, 25, 10, 25], 2) == 5)
