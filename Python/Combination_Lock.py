import sys

sys.stdin = open("combo.in","r")
sys.stdout = open("combo.out","w")

n = int(input())
l1 = [int(x) for x in input().split()]
l2 = [int(x) for x in input().split()]

ans = 0
for i in range(1,n+1):
    for j in range(1,n+1):
        for k in range(1,n+1):

            if (abs(i - l1[0]) <= 2 or abs(i - l1[0]) >= n-2) and (abs(j - l1[1]) <= 2 or abs(j - l1[1]) >= n-2) and (abs(k - l1[2]) <= 2 or abs(k - l1[2]) >= n-2):
                ans += 1
            elif (abs(i - l2[0]) <= 2 or abs(i - l2[0]) >= n-2) and (abs(j - l2[1]) <= 2 or abs(j - l2[1]) >= n-2) and (abs(k - l2[2]) <= 2 or abs(k - l2[2]) >= n-2):
                ans += 1

print(ans)

