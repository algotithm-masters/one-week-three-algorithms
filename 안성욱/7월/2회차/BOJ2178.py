N, M = map(int, input().split())

maze = []
for i in range(N):
    maze.append(list(map(int, input())))

sx, sy = 0, 0

def bfs(x, y):
    q = []
    q.append([x, y])
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    
    while q != []:
        x, y = q.pop(0)
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= 0 and ny >= 0 and nx < N and ny < M and maze[nx][ny] == 1:
                q.append([nx, ny])
                maze[nx][ny] = maze[x][y] + 1
    return maze[N - 1][M - 1]

print(bfs(sx, sy))