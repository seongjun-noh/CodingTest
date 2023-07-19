import sys

t = int(input())

arrNum = list(map(int, sys.stdin.readline().split()))
add, sub, mul, div = map(int, sys.stdin.readline().split())
maxNum, minNum = -1e10, 1e10
def dfs(n, result):
    global add, sub, mul, div, maxNum, minNum, arrNum

    if n == t:
        maxNum = max(maxNum, result)
        minNum = min(minNum, result)
    else:
        if add > 0:
            add -= 1
            dfs(n + 1, result + arrNum[n])
            add += 1
        if sub > 0:
            sub -= 1
            dfs(n + 1, result - arrNum[n])
            sub += 1
        if mul > 0:
            mul -= 1
            dfs(n + 1, result * arrNum[n])
            mul += 1
        if div > 0:
            div -= 1
            dfs(n + 1, int(result / arrNum[n]))
            div += 1


dfs(1, arrNum[0])

print(maxNum)
print(minNum)