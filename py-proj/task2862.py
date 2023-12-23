from typing import List


class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        answer = 0

        for i in range(1, len(nums) + 1):
            if nums[i - 1] == 0:
                continue
            tempAnswer = nums[i - 1]
            nums[i - 1] = 0
            j = 2
            seqIndex = i * j * j
            while seqIndex <= len(nums):
                tempAnswer += nums[seqIndex - 1]
                nums[seqIndex - 1] = 0
                j += 1
                seqIndex = i * j * j
            answer = max(answer, tempAnswer)
        return answer


s = Solution()
print(s.maximumSum([8, 7, 3, 5, 7, 2, 4, 9]) == 16)
