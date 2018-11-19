# String hashes
line = input()
string = input()
B = 29
M = 10 ** 9 + 3
power = [1]
for i in range(1, len(line) + 1):
    power.append((power[-1] * B) % M)

h_line = [0] * (len(line) + 1)
for i in range(1, len(line) + 1):
    h_line[i] = (h_line[i - 1] * B + ord(line[i - 1]) - 96) % M

h_string = [0] * (len(string) + 1)
for i in range(1, len(string) + 1):
    h_string[i] = (h_string[i - 1] * B + ord(string[i - 1]) - 96) % M

for i in range(len(string), len(line) + 1):
    hash_line = (h_line[i] - h_line[i - len(string)] * power[len(string)]) % M
    print(hash_line)
    if hash_line == h_string[-1]:
        print(i - len(string), end=' ')
