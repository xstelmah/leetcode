from typing import List


class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        arr = self.generate(n)
        while k > 1:
            if not self.next(arr):
                return ''
            k -= 1
        for i in range(len(arr)):
            arr[i] = chr(ord('a') + arr[i])
        return ''.join(map(str, arr))

    def next(self, arr: List[int]):
        index = len(arr) - 1
        modifier = 0
        while index >= 0:
            modifier = self.canBeIncreased(arr, index)
            if modifier > 0:
                break
            index -= 1
        if index == -1:
            return False
        arr[index] += modifier
        if index != len(arr) - 1:
            self.fixRemaingItems(arr, index + 1)
        return True

    def canBeIncreased(self, arr: List[int], pos: int):
        if arr[pos] == 2:
            return 0
        if pos == 0:
            return 1
        if arr[pos] < 2 and arr[pos - 1] != arr[pos] + 1:
            return 1
        if arr[pos] == 0 and arr[pos - 1] == 1:
            return 2
        return 0

    def fixRemaingItems(self, arr: List[int], pos: int):
        start = 0 if arr[pos - 1] != 0 else 1
        while pos < len(arr):
            arr[pos] = start
            start = (start + 1) % 2
            pos += 1

    def generate(self, length: int) -> List[int]:
        if length & 1:
            return [0, 1] * (length // 2) + [0]
        return [0, 1] * (length // 2)


s = Solution()
print(s.getHappyString(3, 9) == "cab")
