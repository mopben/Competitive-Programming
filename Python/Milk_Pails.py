import sys

sys.stdin = open("pails.in","r")
sys.stdout = open("pails.out","w")
x,y,m = map(int,input().split())
maxMilk = 0
for i in range(1000):
    for j in range(1000):
        if (x * i) + (y * j) <= m:
            maxMilk = max(maxMilk, (x * i) + (y * j))

print(maxMilk)