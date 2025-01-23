import sys
input = sys.stdin.readline

# 컨셉: 큰 unit부터 value를 빼면서 개수 세면 가장 적은 개수가 될 것이다.
def getMinimumUnitCount(value, units):
    count = 0

    for unit in reversed(units):
        # value가 더 크면 스킵
        if value < unit :
            continue

        
        count += value // unit # unit의 개수는 value를 unit으로 나눈 값임
        value = value % unit # 다음 반복문을 위해 value 값 세팅
        if value == 0:
            break

    return count


# 지폐단위 개수와 금액 입력
N, K = map(int, input().strip().split(" "))

# N만큼 지폐단위 입력 받기
units = [int(input().strip()) for _ in range(N)]

print(getMinimumUnitCount(K, units))
