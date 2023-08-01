import sys

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, a, b):
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


if __name__ == '__main__':
    cost = 0
    N = int(sys.stdin.readline())
    M = int(sys.stdin.readline())
    arr = [list(map(int, sys.stdin.readline().split())) for i in range(M)]

    parent = [i for i in range(0, N + 1)]
    arr.sort(key=lambda x: x[2])

    for i in range(M):
        a, b, c = arr[i]
        a = find_parent(parent, a)
        b = find_parent(parent, b)
        if a != b:
            cost += arr[i][2]
            union_parent(parent, a, b)

    print(cost)