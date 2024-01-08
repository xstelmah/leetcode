import collections
from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        sums = collections.defaultdict(int)
        sums[0] += 1
        s = 0
        answer = 0
        for num in nums:
            s += num
            answer += sums[s - k]
            sums[s] += 1

        return answer



s = Solution()
print(s.subarraySum([1, 1, 1], 2) == 2)
print(s.subarraySum([0, 0, 0], 0) == 6)
print(s.subarraySum([1, 2, 3], 3) == 2)
