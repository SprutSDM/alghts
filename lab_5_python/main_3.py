# Z-function
s = input()
line = [len(s)]
l = 0
r = 0
for i in range(1, len(s)):
    if i <= r:
        line.append(min(r - i + 1, line[i - l]))
    else:
        line.append(0)
    while i + line[i] < len(s) and s[line[i]] == s[i + line[i]]:
        line[i] += 1
    if i + line[i] - 1 > r:
        l = i
        r = i + line[i] - 1
print(*line)