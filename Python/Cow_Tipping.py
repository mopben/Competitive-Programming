import sys

sys.stdin = open("cowtip.in","r")
sys.stdout = open("cowtip.out","w")

n = int(input())
cows = [0] * n

for i in range(n):
    s = input()
    cows[i] = [0] * n
    for j in range(n):
        if s[j] == '0':
            cows[i][j] = False
        else:
            cows[i][j] = True

tips = 0
for i in reversed(range(n)):
    for j in reversed(range(n)):
        if cows[i][j]:
            tips += 1
            for a in range(i+1):
                for b in range(j+1):
                    if cows[a][b]:
                        cows[a][b] = False
                    else:
                        cows[a][b] = True

print(tips)