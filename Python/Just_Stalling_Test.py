from itertools import permutations

n = int(input())
cows = [int(x) for x in input().split()]
stalls = [int(x) for x in input().split()]
ans = 0

for i in (permutations(stalls)):
    counter = 0
    i = list(i)
    for j in range(n):
        if cows[j] <= i[j] and i[j]:
            counter += 1
            i[j] = bool(0)
    if counter == n:
        ans += 1

print(ans)