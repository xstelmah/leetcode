import heapq
from typing import List


class Solution:
    def maxPerformance(self, n: int, speed: List[int], efficiency: List[int], k: int) -> int:
        pairs = [(speed[i], efficiency[i]) for i in range(n)]
        pairs = sorted(pairs, key=lambda pair: pair[1], reverse=True)

        speedSum = 0
        answer = 0
        heap = []

        for i, (s, e) in enumerate(pairs):
            if i < k:
                speedSum += s
                heapq.heappush(heap, s)
            else:
                speedSum += s
                heapq.heappush(heap, s)
                speedSum -= heapq.heappop(heap)

            answer = max(answer, speedSum * e)

        return answer % (10 ** 9 + 7)


s = Solution()
print(s.maxPerformance(6, [2, 10, 3, 1, 5, 8], [5, 4, 3, 9, 7, 2], 2) == 60)
print(s.maxPerformance(6, [2, 10, 3, 1, 5, 8], [5, 4, 3, 9, 7, 2], 3) == 68)
print(s.maxPerformance(6, [2, 10, 3, 1, 5, 8], [5, 4, 3, 9, 7, 2], 4) == 72)
