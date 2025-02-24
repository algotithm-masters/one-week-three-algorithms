A, B = map(int, (input().strip().split(" ")))

'''
1. 간단하게 처음부터 끝까지 합하여 출력한다.
'''

# result = 0
# for i in range(A, B+1) :
#     result = result + i

'''
2. 가우스 공식을 활용하여 수학적으로 계산하여 출력한다.
'''

N = abs(B - A) + 1 # 두 수 사이의 차
result = int(N * (A+B) / 2)

print(result)