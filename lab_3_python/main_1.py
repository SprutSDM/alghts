# Сортировка слиянием
def merge_sort(line):
    if len(line) == 1:
        return line
    ln = len(line) // 2
    rn = len(line) - len(line) // 2
    left = merge_sort(line[:ln])
    right = merge_sort(line[ln:])
    l = 0
    r = 0
    ans = list()
    while l != ln and r != rn:
        if left[l] < right[r]:
            ans.append(left[l])
            l += 1
        else:
            ans.append(right[r])
            r += 1
    if l == ln:
        ans.extend(right[r:])
    else:
        ans.extend(left[l:])
    return ans

n = int(input())
line = list(map(int, input().split()))
print(*merge_sort(line))