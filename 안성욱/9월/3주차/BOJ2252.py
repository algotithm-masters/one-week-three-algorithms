import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

graph = [[] for _ in range(N+1)]
in_degree = [0 for _ in range(N+1)]
q = deque()

for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    in_degree[b] += 1

for i in range(1, N+1):
    if in_degree[i] == 0:
        q.append(i)

students = []

while q:
    student = q.popleft()
    for i in graph[student]:
        in_degree[i] -= 1
        if in_degree[i] == 0:
            q.append(i)
    students.append(student)
            
print(*students)
