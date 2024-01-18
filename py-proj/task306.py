class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        maxNumbersLen = (len(num) * 2) // 3

        def verify(first, second, row):
            res = first + second
            str_res = str(res)
            if len(str_res) > len(row):
                return False
            if len(str_res) == len(row):
                if str_res == row:
                    return True
                return False
            if str_res != row[:len(str_res)]:
                return False
            return verify(second, res, row[len(str_res):])

        for firstLen in range(1, maxNumbersLen):
            for secondLen in range(1, maxNumbersLen - firstLen + 1):
                firstNum = int(num[0:firstLen])
                secondNum = int(num[firstLen: firstLen + secondLen])
                if len(str(firstNum)) != firstLen:
                    continue
                if len(str(secondNum)) != secondLen:
                    continue

                if verify(firstNum, secondNum, num[firstLen + secondLen:]):
                    return True

        return False


s = Solution()

print(s.isAdditiveNumber('112358') == True)
print(s.isAdditiveNumber('123') == True)
print(s.isAdditiveNumber('1023') == False)
print(s.isAdditiveNumber('198019823962') == True)
print(s.isAdditiveNumber('199100199') == True)
print(s.isAdditiveNumber('199100198') == False)
