import sys
from collections import deque

input = sys.stdin.readline
M, N, H = map(int, input().split())

tomatos = [[] for _ in range(H)]
for h in range(H):
    for _ in range(N):
        tomatos[h].append(list(map(int, input().split())))

q = deque()

def bfs():
    dx = [1, 0, 0, -1, 0, 0]
    dy = [0, 1, 0, 0, -1, 0]
    dz = [0, 0, 1, 0, 0, -1]
    
    while q:
        z, y, x = q.popleft()
        
        for i in range(6):
            nx, ny, nz = x+dx[i], y+dy[i], z+dz[i]
        
            if 0 <= nx < M and 0 <= ny < N and 0 <= nz < H and tomatos[nz][ny][nx] == 0:
                tomatos[nz][ny][nx] = tomatos[z][y][x] + 1
                q.append([nz, ny, nx])

zeros = 0
for i in range(H):
    for j in range(N):
        for k in range(M):
            if tomatos[i][j][k] == 1:
                q.append([i, j, k])
            if tomatos[i][j][k] != 0:
                zeros += 1

if zeros == M*N*H:
    print(0)
    exit(0)
        
bfs()
         
result = 0
for i in range(H):
    for j in range(N):
        for k in range(M):
            if tomatos[i][j][k] == 0:
                print(-1)
                exit(0)
            result = max(result, tomatos[i][j][k])

print(result - 1)