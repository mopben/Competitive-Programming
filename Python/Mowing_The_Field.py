import sys

sys.stdin = open("mowing.in","r")
sys.stdout = open("mowing.out","w")

n = int(input())

field = [0] * 1001
d = [0] * n
s = [0] * n

for i in range(n):
    d[i],s[i] = input().split()
    s[i] = int(s[i])

for i in range(1001):
    field[i] = [0] * 1001
    
y = 0
x = 0
ans = 9999999999
time = 0
for i in range(n):
    dirY = 0
    dirX = 0
    if d[i] == 'N':
        dirY = 1
    if d[i] == 'S':
        dirY = -1
    if d[i] == 'E':
        dirX = 1
    if d[i] == 'W':
        dirX = -1
    for j in range(s[i]):
        time += 1
        x += dirX
        y += dirY
        if field[y][x] != 0:
            ans = min(ans, time - field[y][x])
        field[y][x] = time



if ans == 9999999999:
    print(-1)
else:
    print(ans)

        
