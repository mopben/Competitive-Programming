import sys

sys.stdin = open("triangles.in","r")
sys.stdout = open("triangles.out","w")
       
n = int(input())
f = [0] * n

for i in range(n):
    f[i] = input().split() #fence posts
    f[i][0] = int(f[i][0]); f[i][1] = int(f[i][1])
    
maxArea = 0
for a in range(n):
    for b in range(n):
        for c in range(n):
            if f[a][0] == f[c][0] and f[a][1] == f[b][1]:
                area = abs(f[b][0] - f[a][0]) * abs(f[c][1] - f[a][1])
                maxArea = max(maxArea, area)
                
print(maxArea)
                