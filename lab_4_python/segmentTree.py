# Segment tree
import math


def get_max_line(q, p):
    q += base
    p += base
    ans = dp[q]
    while q <= p:
        if dp[q][0] > ans[0]:
            ans = dp[q]
        elif dp[q][0] == ans[0]:
            ans = (dp[q][0], min(ans[1], dp[q][1]))
        if dp[p][0] > ans[0]:
            ans = dp[p]
        elif dp[p][0] == ans[0]:
            ans = (dp[p][0], min(ans[1], dp[p][1]))
        
        if q % 2 == 1:
            q = (q + 1) // 2
        else:
            q //= 2
        if (p % 2 == 0):
            p = (p - 1) // 2
        else:
            p //= 2
    return ans


n = int(input())
line = list(map(int, input().split()))
base = 2**math.ceil(math.log2(n))
dp = [0] * (base * 2)
for i in range(0, base):
    if i < n:
        dp[i + base] = (line[i], i + 1)
    else:
        dp[i + base] = (0, i + 1)

for i in range(base - 1, 0, -1):
    if dp[i * 2][0] >= dp[i * 2 + 1][0]:
        dp[i] = dp[i * 2]
    else:
        dp[i] = dp[i * 2 + 1]

k = int(input())
ans = []
for i in range(k):
    l, r = map(int, input().split())
    ans.append(get_max_line(l - 1, r - 1)[1])
print(*ans)
