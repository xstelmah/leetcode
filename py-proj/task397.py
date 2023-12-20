import math


class Solution:
    def integerReplacement(self, n: int) -> int:
        answer = 0
        pow2 = 1 << 31
        while n > 1:
            if n % 2 == 0:
                answer += 1
                n //= 2
            else:
                gcd1 = math.gcd(pow2, n + 1)
                gcd2 = math.gcd(pow2, n - 1)
                answer += 1
                if gcd2 == n - 1:
                    n -= 1
                elif gcd1 > gcd2:
                    n += 1
                else:
                    n -= 1
        return answer

    def integerReplacement2(self, n: int) -> int:
        dp = [0, 0, 1, 2]

        for i in range(4, min(1024, n + 1)):
            if i % 2 == 0:
                dp.append(dp[i // 2] + 1)
            else:
                dp.append(min(dp[(i + 1) // 2], dp[(i - 1) // 2]) + 2)

        # for i, el in enumerate(dp):
        #     print(f'{i} -> {el}')
        return dp[n]


s = Solution()
for num in range(1, 1024):
    if s.integerReplacement(num) != s.integerReplacement2(num):
        print(f'{num} -> {s.integerReplacement(num)}, -> {s.integerReplacement2(num)}')
