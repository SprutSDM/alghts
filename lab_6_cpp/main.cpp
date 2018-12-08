#include <iostream>

using namespace std;




int main()
{
    int n, k;
    cin >> n >> k;
    int p[4][4];
    p[0][0] = 0;
    p[0][1] = 1;
    p[0][2] = 1;
    p[0][3] = 1;

    p[1][0] = 0;
    p[1][1] = 0;
    p[1][2] = 2;
    p[1][3] = 0;

    p[2][0] = 0;
    p[2][1] = 2;
    p[2][2] = 0;
    p[2][3] = 0;

    p[3][0] = 1;
    p[3][1] = 1;
    p[3][2] = 1;
    p[3][3] = 0;

    int dp[4][2001];
    int dp_new[4][2001];
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 2001; j++) {
            dp[i][j] = 0;
            dp_new[i][j] = 0;
        }
    }
    dp[0][1] = 1;
    dp[1][2] = 1;
    dp[2][2] = 1;
    dp[3][1] = 1;
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < 4; j++) {
            for (int e = 1; e < k + 1; e++) {
                for (int q = 0; q < 4; q++) {
                    if (p[j][q] + e <= k)
                        dp_new[q][e + p[j][q]] = (dp_new[q][e + p[j][q]] + dp[j][e]) % 998244353;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2001; j++) {
                dp[i][j] = dp_new[i][j];
                dp_new[i][j] = 0;
            }
        }
    }
    int ans = 0;
    for (int i = 0; i < 4; i++) {
        ans = (ans + dp[i][k]) % 998244353;
    }
    cout << ans;
}
