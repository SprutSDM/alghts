# Prefix function
s = input()
line = [0]
for i in range(1, len(s)):
    j = line[i - 1]
    while s[j] != s[i] and j != 0:
        j = line[j - 1]
    if s[i] == s[j]:
        j += 1
    line.append(j)
print(len(s) - line[-1])