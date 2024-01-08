class Solution:
    def angleClock(self, hour: int, minutes: int) -> float:
        minutesAngle = 6 * minutes
        hourAngle = 30 * hour + 30 * minutes / 60

        return min(abs(hourAngle - minutesAngle), 360 - abs(hourAngle - minutesAngle))


s = Solution()
print(s.angleClock(12, 30) == 165)
print(s.angleClock(3, 15) == 7.5)
