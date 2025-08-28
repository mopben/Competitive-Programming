import sys
sys.setrecursionlimit(10000)
sys.stdin = open("cowart.in","r")
sys.stdout = open("cowart.out","w")

#find groups------------------------------------------
def check(y,x):
    groups[y][x] = True
    if p[y][x] == p[y+1][x] and not groups[y+1][x]:
        check(y+1, x)
    if p[y][x] == p[y-1][x] and not groups[y-1][x]:
        check(y-1, x)
    if p[y][x] == p[y][x+1] and not groups[y][x+1]:
        check(y, x+1)
    if p[y][x] == p[y][x-1] and not groups[y][x-1]:
        check(y, x-1)
    
    return False

#take inputs------------------------------------------------------
n = int(input())
p = [0] * n

for i in range(n):
    s = input()
    p[i] = [0] * n
    for j in range(n):
        p[i][j] = s[j] 
        
    p[i].insert(0,-1); p[i].append(-1)

p.insert(0,[-1] * (n+2)); p.append([-1]*(n+2))

#make groups----------------------------------------
groups = [0] * (n+2)
for i in range(len(groups)):
    groups[i] = [0] * (n+2)

#find human regions----------------------------------------

h_regions = 0
for i in range(1,n+1):
    for j in range(1,n+1):
        if not groups[i][j]:
            check(i,j)
            h_regions += 1

#convert red into green-------------------------------------
for i in range(1,n+1):
    for j in range(1,n+1):
        if p[i][j] == 'R':
            p[i][j] = 'G'

c_regions = 0

#make groups ----------------------------------------
groups = [0] * (n+2)
for i in range(len(groups)):
    groups[i] = [0] * (n+2)

#find human regions----------------------------------------------
for i in range(1,n+1):
    for j in range(1,n+1):
        if not groups[i][j]:
            check(i,j)
            c_regions += 1

print(h_regions,c_regions)