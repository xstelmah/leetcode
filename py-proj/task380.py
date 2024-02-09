import collections
import random
from typing import List


class RandomizedSet:

    def __init__(self):
        self.arr = []
        self.st = set()

    def insert(self, val: int) -> bool:
        if val in self.st:
            return False
        self.arr.append(val)
        self.st.add(val)
        return True

    def remove(self, val: int) -> bool:
        if val not in self.st:
            return False
        self.arr.remove(val)
        self.st.remove(val)
        return True

    def getRandom(self) -> int:
        return self.arr[random.randint(0, len(self.arr) - 1)]

