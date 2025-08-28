n,m = input().split()
n = int(n)
m = int(m)

grid = [0] * n
for i in range(n):
    grid[i] = [0] * m
    #inputs seperated by space
    #s = input().split()
    #inputs not seperated
    s = input() #<---
    for j in range(m):
        grid[i][j] = s[j]

print(grid)
print(grid[0][0])