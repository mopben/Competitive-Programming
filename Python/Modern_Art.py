import sys

#sys.stdin = open("art.in","r")
#sys.stdout = open("art.out","w")
n = int(input())

canvas = [0] * n

for i in range(n):
    canvas[i] = input()
    
visible = []

for i in range(n):
    for j in range(n):
        if canvas[i][j] not in visible and canvas[i][j] != '0':
            visible.append(canvas[i][j])
            
ans = visible.copy()
for col in (visible):
    up = 10; down = -1
    right = -1; left = 10
    for y in range(n):
        for x in range(n):
            if canvas[y][x] == col:
                down = max(down, y); up = min(up, y)
                right = max(right, x); left = min(left, x)

    for y in range(up, down+1):
        for x in range(left,right+1):
            if canvas[y][x] != col and canvas[y][x] in ans:
                ans.remove(canvas[y][x])
            
print(len(ans))