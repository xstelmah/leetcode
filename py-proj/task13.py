class Solution:
    letterMap = {
        'I': 1,
        'IV': 4,
        'V': 5,
        'IX': 9,
        'X': 10,
        'XL': 40,
        'L': 50,
        'XC': 90,
        'C': 100,
        'CD': 400,
        'D': 500,
        'CM': 900,
        'M': 1000
    }

    def romanToInt(self, s: str) -> int:
        result = 0
        i = 0
        while i < len(s):
            char = s[i]
            if i == len(s) - 1:
                result += self.letterMap[char]
            elif char + s[i + 1] in self.letterMap:
                result += self.letterMap[char + s[i + 1]]
                i += 1
            else:
                result += self.letterMap[char]
            i += 1
        return result


print(Solution().romanToInt("III") == 3)
print(Solution().romanToInt("LVIII") == 58)
print(Solution().romanToInt("MCMXCIV") == 1994)
