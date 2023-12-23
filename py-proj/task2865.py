from typing import List


class Solution:
    def maximumSumOfHeights(self, maxHeights: List[int]) -> int:
        answer = 0

        for index in range(len(maxHeights)):
            if index > 0 and maxHeights[index] < maxHeights[index - 1]:
                continue
            left = index - 1
            right = index + 1
            curMax = maxHeights[index]
            tempAnswer = curMax
            while left >= 0:
                curMax = min(curMax, maxHeights[left])
                tempAnswer += curMax
                left -= 1

            curMax = maxHeights[index]
            while right < len(maxHeights):
                curMax = min(curMax, maxHeights[right])
                tempAnswer += curMax
                right += 1

            answer = max(answer, tempAnswer)

        return answer


s = Solution()
print(s.maximumSumOfHeights([6, 5, 3, 9, 2, 7]) == 22)
print(s.maximumSumOfHeights([5, 3, 4, 1, 1]) == 13)
print(s.maximumSumOfHeights([5, 3, 4, 1, 1]) )
