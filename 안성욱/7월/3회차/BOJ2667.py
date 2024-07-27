import sys

input = sys.stdin.readline
N = int(input())

house = []
for _ in range(N):
    house.append(list(map(int, input().rstrip())))

count = 0
house_number = []

def dfs(x, y):
    global count
    dx = [1, 0, -1, 0]
    dy = [0, -1, 0, 1]
    
    if x >= 0 and x < N and y >= 0 and y < N and house[x][y] == 1:
        house[x][y] = 0
        count += 1
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            dfs(nx, ny)

for i in range(N):
    for j in range(N):
        if house[i][j] == 1:
            dfs(i, j)
            house_number.append(count)
            count = 0
            
house_number.sort()

print(len(house_number))
for i in house_number:
    print(i)
