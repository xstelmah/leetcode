from typing import List


class Solution:
    def numOfSubarrays(self, arr: List[int], k: int, threshold: int) -> int:
        index = k - 1
        sm = sum(arr[:index])
        answer = 0
        threshold *= k

        while index < len(arr):
            sm += arr[index]
            if sm >= threshold:
                answer += 1
            sm -= arr[index - k + 1]
            index += 1

        return answer


s = Solution()
print(s.numOfSubarrays([2, 2, 2, 2, 5, 5, 5, 8], 3, 4) == 3)
print(s.numOfSubarrays([11, 13, 17, 23, 29, 31, 7, 5, 2, 3], 3, 5) == 6)
print(s.numOfSubarrays([11, 13, 17, 23, 29, 31, 7, 5, 2, 3], 3, 5))
