import heapq


n = int(input())
p = list(map(int, input().split()))
k = int(input())
line = [list() for i in range(n)]
for i in range(k):
    x, y = map(int, input().split())
    x -= 1
    y -= 1
    line[x].append(y)
    line[y].append(x)
heap = []
b = [False] * n
b[0] = True
heapq.heappush(heap, 0)
ans = -1
while len(heap) != 0:
    z = heapq.heappop(heap)
    v = z % 100
    c = z // 100
    for u in line[v]:
        if not b[u]:
            heapq.heappush(heap, (c + p[v]) * 100 + u)
            b[u] = True
        if u == n - 1:
            if ans == -1:
                ans = c + p[v]
            else:
                ans = min(ans, c + p[v])
print(ans)