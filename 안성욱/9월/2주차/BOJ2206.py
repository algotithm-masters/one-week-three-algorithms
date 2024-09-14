import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
arr = [[],[]]
for i in range(N):
    cur = input().rstrip()
    arr[0].append(list(map(int, cur)))
    arr[1].append(list(map(int, cur)))
q = deque()

def bfs():
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    
    while q:
        x, y, z = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if arr[z][nx][ny] == 0 and z == 0:
                    arr[z][nx][ny] = arr[z][x][y] + 2
                    q.append([nx, ny, 0])
                elif arr[z][nx][ny] == 0 and z == 1:
                    arr[z][nx][ny] = arr[z][x][y] + 2
                    q.append([nx, ny, 1])
                elif arr[z][nx][ny] == 1 and z == 0:
                    arr[1][nx][ny] = arr[0][x][y] + 2
                    q.append([nx, ny, 1])
    
    return

q.append([0, 0, 0])
bfs()

A = arr[0][N-1][M-1]
B = arr[1][N-1][M-1]

if N == M == 1:
    print(1)
elif min(A, B) == 0:
    if A == B:
        print(-1)
    else:
        print(int(max(A, B)/2 + 1))
else:
    print(int(min(A, B)/2 + 1))
