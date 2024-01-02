from typing import List


class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        nums = sorted(nums)
        answer = -1
        count = 0
        sum = 0
        for i, num in enumerate(nums):
            sum += num
            count += 1
            if num < (sum - num) and count >= 3:
                answer = sum

        return answer


s = Solution()
print(s.largestPerimeter([5, 5, 5]) == 15)
print(s.largestPerimeter([1, 12, 1, 2, 5, 50, 3]) == 12)
print(s.largestPerimeter([5, 5, 50]) == -1)
