import sys

sys.stdin = open("records.in","r")
sys.stdout = open("records.out","w")
n = int(input())

seen = []
counter = dict()
for i in range(n):
    cows = input().split()
    cows = set(cows)
    cows = frozenset(cows)
    
    if cows in seen:
        counter[cows] += 1
    else:
        seen.append(cows)   
        counter[cows] = 1

ans = 0
for i in counter.keys():
    ans = max(ans,counter[i])

print(ans)