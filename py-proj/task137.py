from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        arr = [0] * 32
        for num in nums:
            for bitShift in range(32):
                arr[bitShift] += (num >> bitShift) & 1

        result = 0
        for i, num in enumerate(arr):
            if i < 31:
                result += (arr[i] % 3 << i)
            else:
                result += -(arr[31] % 3) * (1 << 31) # 32 bit - sign bit
        return result


print(Solution().singleNumber([2,2,3,2]) == 3)
print(Solution().singleNumber([0,1,0,1,0,1,99]) == 99)
print(Solution().singleNumber([0,1,0,1,0,1,-1]) == -1)
print(Solution().singleNumber([0,1,0,1,0,1,-545]) == -545)
