# 가장 적은 시간이 든다는 것은 시간이 많이 드는 작업을 최대한 늦게 하는 것이다.

import sys
input = sys.stdin.readline

def getMinimumTime(times):
    # 1. 시간을 오름차순으로 저장한다.
    sortedTimes = sorted(times)

    wholeTimeTaken = 0
    # 2. 소모 시간을 구한다.
    for i in range(len(sortedTimes)):
        wholeTimeTaken += sum(sortedTimes[0:i+1])
    

    return wholeTimeTaken

N = int(input())
times = map(int, input().strip().split(" "))
print(getMinimumTime(times))