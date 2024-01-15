from typing import List


class Solution:
    def balancedString(self, s: str) -> int:
        mp = {'Q': 0, 'W': 0, 'E': 0, 'R': 0}
        left = 0
        answer = len(s)
        right = len(s)
        size = right // 4
        while left < right:
            if mp[s[left]] == size:
                break
            mp[s[left]] += 1
            left += 1

        if left == right:
            return 0

        right -= 1
        # left += 1
        while right >= 0:
            if mp[s[right]] == size:
                answer = min(answer, right - left + 1)
                if left == 0:
                    break
                while left >= 1 and s[left - 1] != s[right]:
                    left -= 1
                    mp[s[left]] -= 1
                    continue
                if left == 0:
                    break
                left -= 1
                mp[s[left]] -= 1

            mp[s[right]] += 1
            right -= 1
        return answer


s = Solution()
print(s.balancedString("QWER") == 0)
print(s.balancedString("QQWE") == 1)
print(s.balancedString("QQQW") == 2)
print(s.balancedString("WWEQERQWQWWRWWERQWEQ") == 4)
print(s.balancedString("WWWEQRQEWWQQQWQQQWEWEEWRRRRRWWQE") == 5)
print(s.balancedString("REEWRREWWWEREEQEEEEWREERQRWEQWQRQWRWRWRRRRERQEWERQQQQWWQERQWRQEQERQE") == 6)
# print(s.balancedString("REEWRREWWWEREEQEEEEWREERQRWEQWQRQWRWRWRRRRERQEWERQQQQWWQERQWRQEQERQE"))
