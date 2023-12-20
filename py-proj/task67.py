class Solution:
    def addBinary(self, a: str, b: str) -> str:
        chrs = []
        i1 = len(a) - 1
        i2 = len(b) - 1
        reminder = 0
        while i1 >= 0 or i2 >= 0 or reminder != 0:
            result = reminder
            if i1 >= 0:
                result += int(a[i1]) - int('0')
            if i2 >= 0:
                result += int(b[i2]) - int('0')
            if result > 1:
                result %= 2
                reminder = 1
            else:
                reminder = 0
            chrs.append(result)
            i1 -= 1
            i2 -= 1
        return ''.join(str(ch) for ch in reversed(chrs))


print(Solution().addBinary("11","1") == "100")
print(Solution().addBinary("1010","1011") == "10101")
print(Solution().addBinary("1010","1011"))