import sys

input = sys.stdin.readline
N = int(input())

def hanoi(num, start, end):
    if num == 1:
        print(start, end)
    else:
        hanoi(num-1, start, 6-start-end)
        print(start, end)
        hanoi(num-1, 6-start-end, end)
        
print(2**N - 1)
hanoi(N, 1, 3)

