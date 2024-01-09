from typing import List


class Solution:
    def numOfBurgers(self, tomatoSlices: int, cheeseSlices: int) -> List[int]:
        if cheeseSlices * 4 < tomatoSlices or cheeseSlices * 2 > tomatoSlices or tomatoSlices & 1:
            return []
        return [tomatoSlices // 2 - cheeseSlices, cheeseSlices - (tomatoSlices // 2 - cheeseSlices)]


s = Solution()
print(s.numOfBurgers(16, 7) == [1, 6])
print(s.numOfBurgers(14, 7) == [0, 7])
print(s.numOfBurgers(12, 7) == [])
print(s.numOfBurgers(30, 7) == [])
print(s.numOfBurgers(102, 41) == [10, 31])
print(s.numOfBurgers(103, 41) == [])
print(s.numOfBurgers(104, 41) == [11, 30])
