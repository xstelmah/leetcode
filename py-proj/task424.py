import collections


class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        char_pos = collections.defaultdict(list)
        answer = 0

        for i, chr in enumerate(s):
            char_pos[chr].append(i)

        for pos in char_pos.values():
            ln = len(pos)
            if ln == 1:
                answer = max(answer, min(len(s), 1 + k))
                continue
            leftIndex = 0
            rightIndex = 0
            tempK = k
            while leftIndex < ln - 1 and rightIndex < ln - 1:
                while rightIndex < ln - 1 and pos[rightIndex + 1] - pos[rightIndex] - 1 <= tempK:
                    tempK -= pos[rightIndex + 1] - pos[rightIndex] - 1
                    rightIndex += 1
                answer = max(answer,
                             pos[rightIndex] - pos[leftIndex] + 1 + min(len(s) - (pos[rightIndex] - pos[leftIndex] + 1),
                                                                        tempK))
                if leftIndex < rightIndex:
                    tempK += pos[leftIndex + 1] - pos[leftIndex] - 1
                    leftIndex += 1

                if leftIndex == rightIndex:
                    rightIndex = rightIndex + 1
                    leftIndex = leftIndex + 1

        return answer


s = Solution()
# print(s.characterReplacement('AABABBA', 1) == 4)
# print(s.characterReplacement('ABAB', 2) == 4)
# print(s.characterReplacement('ABCDE', 1) == 2)
# print(s.characterReplacement('ABmAB', 2) )
# print(s.characterReplacement('ABCABBBACBB', 2) == 7)
# print(s.characterReplacement('ABCABBBACBB', 0) == 3)
print(s.characterReplacement('KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF', 4))
