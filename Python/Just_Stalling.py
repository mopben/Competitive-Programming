
n = int(input())
cows = [int(x) for x in input().split()]
stalls = [int(x) for x in input().split()]

cows.sort()
stalls.sort()

counter = 0
previousCow = cows[n-1]
fitIn = [0] * n
for i in reversed(range(n)):
    if cows[i] != previousCow:
        counter += 1
    for j in range(n):
        if cows[i] <= stalls[j]:
            fitIn[i] += 1
   
    fitIn[i] -= counter
    previousCow = cows[i]

ans = 1

for i in fitIn:
    ans *= i

print(ans)