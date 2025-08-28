import sys

sys.stdin = open("skidesign.in","r")
sys.stdout = open("skidesign.out","w")

n = int(input())

hills = []
costs = [0] * n
for i in range(n):
    hills.append(int(input()))

ans = [0] * 83
for i in range(83):
    for j in range(n):
        if hills[j] > i+17:
            ans[i] += (hills[j] - (i+17))**2
        if hills[j] < i:
            ans[i] += (i - hills[j])**2

print(min(ans))
            
        