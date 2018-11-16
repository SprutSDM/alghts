# Fenwick tree
def change(i, ds):
    while i <= n:
        fv[i] += ds
        i = (i | (i - 1)) + 1


def get_sum(i):
    s = 0
    while i != 0:
        s += fv[i]
        i = i & (i - 1)
    return s


n = int(input())
line = [0] * n
line_1 = list(map(int, input().split()))
fv = [0] * (n + 1)
for i in range(n):
    change(i + 1, line_1[i])
    line[i] = line_1[i]
k = int(input())
for i in range(k):
    o, q, p = input().split()
    q, p = int(q), int(p)
    if o == 's':
        print(get_sum(p) - get_sum(q - 1), end=' ')
    else:
        change(q, p - line[q - 1])
        line[q - 1] = p
