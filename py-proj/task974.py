import collections
from typing import List


class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        sums = collections.defaultdict(int)
        sums[0] += 1
        s = 0
        answer = 0
        for num in nums:
            s += num
            s %= k
            answer += sums[s]
            sums[s] += 1
        return answer


s = Solution()
print(s.subarraysDivByK([4, 5, 0, -2, -3, 1], 5) == 7)
print(s.subarraysDivByK([4, 5, 0, -2, -3, 1], 5))
