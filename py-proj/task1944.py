from typing import List


class Solution:
    def canSeePersonsCount(self, heights: List[int]) -> List[int]:
        stack = []
        answers = []
        for cur in reversed(heights):
            tempAnswer = 0
            while len(stack) > 0:
                last = stack[-1]
                tempAnswer += 1
                if last > cur:
                    break
                else:
                    stack.pop()
            stack.append(cur)
            answers.append(tempAnswer)

        return list(reversed(answers))


s = Solution()
print(s.canSeePersonsCount([10,6,8,5,11,9]) == [3,1,2,1,1,0])
print(s.canSeePersonsCount([10,6,8,5,11,9]))
print(s.canSeePersonsCount([5,1,2,3,10]) == [4,1,1,1,0])
print(s.canSeePersonsCount([5,1,2,3,10]))