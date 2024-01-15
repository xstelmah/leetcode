from typing import List


class Solution:
    def minimumBeautifulSubstrings(self, s: str) -> int:
        combinations = {"1"}
        powFive = 5
        while powFive < 65536:
            combinations.add(bin(powFive)[2:])
            powFive *= 5

        def func(s2: str) -> int:
            if s2 in combinations:
                return 1

            answer = 16

            for i in range(1, len(s2)):
                if s2[:i] in combinations:
                    res = func(s2[i:])
                    if res == -1:
                        continue
                    answer = min(answer, 1 + res)

            return -1 if answer == 16 else answer

        return func(s)


s = Solution()
print(s.minimumBeautifulSubstrings("1011") == 2)
print(s.minimumBeautifulSubstrings("111") == 3)
print(s.minimumBeautifulSubstrings("0") == -1)
print(s.minimumBeautifulSubstrings("1") == 1)
print(s.minimumBeautifulSubstrings("111111111111111") == 15)
print(s.minimumBeautifulSubstrings("10110111111011") == 4)
