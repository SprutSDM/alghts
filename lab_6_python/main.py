def rmap(): return map(int, input().split())
def rlist(): return list(map(int, input().split()))
def rdi(): return int(input())


def main():
    n, k = rmap()
    p = [[0] * 4 for i in range(4)]
    p[0][0] = 0
    p[0][1] = 1
    p[0][2] = 1
    p[0][3] = 1
    
    p[1][0] = 0
    p[1][1] = 0
    p[1][2] = 2
    p[1][3] = 0
    
    p[2][0] = 0
    p[2][1] = 2
    p[2][2] = 0
    p[2][3] = 0
    
    p[3][0] = 1
    p[3][1] = 1
    p[3][2] = 1
    p[3][3] = 0
    
    ppp = 0
    dp = [[0] * (k + 2) for i in range(4)]
    dp_new = [[0] * (k + 2) for i in range(4)]
    dp[0][1] = 1
    dp[1][2] = 1
    dp[2][2] = 1
    dp[3][1] = 1
    for i in range(1, n):
        for j in range(4):
            for e in range(1, k + 1):
                for q in range(4):
                    if p[j][q] + e <= k:
                        dp_new[q][e + p[j][q]] += dp[j][e]
        dp = dp_new
        dp_new = [[0] * (k + 2) for i in range(4)]
    ans = 0
    for i in range(4):
        ans += dp[i][k]
    print(ans)

main()