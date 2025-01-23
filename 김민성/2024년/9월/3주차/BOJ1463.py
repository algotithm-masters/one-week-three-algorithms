import sys

# 동적 프로그래밍을 사용할 예정
# 타뷸레이션 방식임
def countOperationsDuringNToOne(n):
    dp = [0] * (n + 1)
    dp[1] = 0

    for i in range(2, n + 1):
        minimumCount = sys.maxsize
        if(i%3 == 0):
            count = countOperationsDuringNToOne(i // 3) + 1
            if minimumCount > count:
                minimumCount = count
        if(i%2 == 0):
            count = countOperationsDuringNToOne(i // 2) + 1
            if minimumCount > count:
                minimumCount = count
        
        count = countOperationsDuringNToOne(i - 1) + 1
        if minimumCount > count:
                minimumCount = count

        dp[i] = minimumCount

    return dp[n]


# 숫자 입력 받기
N = int(input())
print(countOperationsDuringNToOne(N))