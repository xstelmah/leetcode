class Solution:
    def countSubstrings(self, s: str) -> int:
        dp = [[(0, False) for _ in range(len(s))] for _ in range(len(s) + 1)]
        for x in range(len(s)):
            dp[x][x] = (1, True)
        for size in range(2, len(s) + 1):
            for index in range(len(s) - size + 1):
                left = index
                right = index + size - 1
                isPal = False
                cnt = 0
                if s[left] == s[right] and (right - left == 1 or dp[left + 1][right - 1][1]):
                    isPal = True
                    cnt += 1
                common = 0
                if right - left > 1:
                    common = dp[left + 1][right - 1][0]
                dp[left][right] = (
                    cnt + dp[left][right - 1][0] + dp[left + 1][right][0] - common, isPal)
        return dp[0][len(s) - 1][0]


s = Solution()
print(s.countSubstrings('aaa') == 6)
# print(s.countSubstrings('aaa'))
print(s.countSubstrings('aaaa') == 10)
