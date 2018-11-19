#Quick sort
import random


def qsort(line):
    if len(line) <= 1:
        return line
    left, merdge, right = [], [], []
    x = random.choice(line)
    for elem in line:
        if elem < x:
            left.append(elem)
        elif elem == x:
            merdge.append(elem)
        elif elem > x:
            right.append(elem)
    return qsort(left) + merdge + qsort(right)


n = input()
print(*qsort(list(map(int, input().split()))))
