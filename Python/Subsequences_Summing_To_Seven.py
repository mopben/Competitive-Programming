n = int(input())

cows = []

for i in range(n):
    cows.append(int(input()))

prefix = [0]

for i in range(n):
    prefix.append((prefix[i] + cows[i])%7)

print(prefix)
