from typing import List, Set


class Solution:
    def longestValidSubstring(self, word: str, forbidden: List[str]) -> int:
        forbidden = set(forbidden)
        answer = 0
        left = 0
        for right in range(len(word) + 1):
            while left < right:
                temp = word[left: right]
                if self.isValid(temp, forbidden):
                    break
                else:
                    left += 1
            if left >= right:
                continue
            answer = max(answer, right - left)
        return answer

    def isValid(self, word: str, forbidden: Set[str]) -> bool:
        index = 1
        while index <= 10 and len(word) - index >= 0:
            if word[-index:] in forbidden:
                return False
            index += 1

        return True


s = Solution()
print(s.longestValidSubstring("cbaaaabc", ["aaa", "cb"]) == 4)
print(s.longestValidSubstring("leetcode", ["de", "le", "e"]) == 4)
