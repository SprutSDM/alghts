import collections
 
 
s1, s2 = map(str, input().split())
hors_1 = (ord(s1[0]) - 97, int(s1[1]) - 1)
hors_2 = (ord(s2[0]) - 97, int(s2[1]) - 1)
c = [[False] * 8 for i in range(8)]
step = [(2, 1), (-2, -1), (-2, 1), (2, -1), (1, 2), (-1, -2), (1, -2), (-1, 2)]
deq = collections.deque()
deq.append((hors_1[0], hors_1[1], 0))
c[hors_1[0]][hors_1[1]] = True
while len(deq) != 0:
    x, y, k = deq.popleft()
    if (x, y) == hors_2:
        if k % 2 == 0:
            print(k // 2)
        else:
            print(-1)
        break
    for i, j in step:
        if 0 <= x + i < 8 and 0 <= y + j < 8 and not c[x + i][y + j]:
            c[x + i][y + j] = True
            deq.append((x + i, y + j, k + 1))