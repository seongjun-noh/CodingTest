import sys


def dfs(x, y):
    if arr[x][y] == 1:
        return
    elif arr[x][y] == '-':
        if y + 1 < m and arr[x][y + 1] == '-':
            dfs(x, y + 1)
    elif arr[x][y] == '|':
        if x + 1 < n and arr[x + 1][y] == '|':
            dfs(x + 1, y)
    arr[x][y] = 1


n, m = map(int, sys.stdin.readline().split())

count = 0
arr = []
for _ in range(n):
    arr.append(list(input()))

for i in range(n):
    for j in range(m):
        if arr[i][j] == '-' or arr[i][j] == '|':
            dfs(i, j)
            count += 1

print(count)
