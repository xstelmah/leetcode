import collections
from typing import List


class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        target = sum(nums) % p
        if not target:
            return 0
        answer = len(nums)
        tempSum = 0
        mp = {0: -1}
        for i, num in enumerate(nums):
            tempSum = tempSum + num

            if (tempSum - target) % p in mp:
                answer = min(answer, i - mp.get((tempSum - target) % p))

            mp[tempSum % p] = i

        return answer if answer < len(nums) else -1


s = Solution()
print(s.minSubarray([1, 2, 1, 3, 1, 2], 6) == 2)
print(s.minSubarray([1, 2, 1, 3, 1, 2], 6))
