import sys
from collections import deque

input = sys.stdin.readline
M, N = map(int,input().split())

tomatos = []
for i in range(N):
    tomatos.append(list(map(int, input().split())))
    
q = deque()

def bfs():
    dx = [1, 0, -1, 0]
    dy = [0, -1, 0, 1]
    
    while q:
        x, y = q.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= 0 and ny >= 0 and nx < N and ny < M and tomatos[nx][ny] == 0:
                tomatos[nx][ny] = tomatos[x][y] + 1
                q.append([nx, ny])
    return 
    
for n in range(N):
    for m in range(M):
        if tomatos[n][m] == 1:
            q.append([n, m])

bfs()

result = 0
for i in tomatos:
    for j in i:
        if j == 0:
            print(-1)
            exit(0)
    result = max(result, max(i))
print(result - 1)