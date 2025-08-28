#import sys

#sys.stdin = open("fairphoto.in","r")
#sys.stdout = open("fairphoto.out","w")

def comp(arr):
    return arr[0]
    
n = int(input())
cows = []

for i in range(n):
    cows.append(input().split())
    cows[i][0] = int(cows[i][0])

cows.sort(key = comp)
sums = [0]
for i in range(n):
    if cows[i][1] == 'G':
        sums.append(sums[i] + 1)
    else:
        sums.append(sums[i] - 1)

ans = 0
for i in range(n-1):
    for j in reversed(range(n+1)):
        if sums[i] - sums[j] == 0 and i != j:
            ans = max(ans,cows[j-1][0] - cows[i][0])
print(cows)
print(sums)
print(ans)     