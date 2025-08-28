import sys

sys.stdin = open("cowjog.in","r")
sys.stdout = open("cowjog.out","w")

def comp(arr):
    return arr[0]

n = int(input())

cows = [0] * n

for i in range(n):
    cows[i] = input().split()
    cows[i][0] = int(cows[i][0]); cows[i][1] = int(cows[i][1])

cows.sort(key = comp)
groups = 1

for i in reversed(range(1,n)):
    if cows[i][1] >= cows[i-1][1]:
        groups += 1
    else:
        cows[i-1][1] = cows[i][1]


print(groups)