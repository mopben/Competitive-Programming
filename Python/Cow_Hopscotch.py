import sys

sys.stdin = open("hopscotch.in","r")
sys.stdout = open("hopscotch.out","w")

def check(y,x):
    global counter
    if y == r-1 and x == c-1:
        return True

    for i in range(y+1,r):
        for j in range(x+1,c):
            color = grid[y][x]
            if color != grid[i][j]:
                if check(i,j):
                    counter += 1
    
    return 0

r,c = map(int,input().split())

grid = [0] * r

for i in range(r):
    grid[i] = input()

counter = 0
check(0,0)
print(counter)