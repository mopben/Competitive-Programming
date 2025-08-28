import sys

sys.stdin = open("crosswords.in","r")
sys.stdout = open("crosswords.out","w")

n,m = map(int,input().split())

grid = [0] * n; clue_loc = [False] * n

for i in range(n):
    s = input()
    grid[i] = [0] * m; clue_loc[i] = [False] * m
    for j in range(m):
        grid[i][j] = s[j]


clues = 0
for y in range(n):
    for x in range(m):
        
        if grid[y][x] == '.':
            #horizontal-----------------------------------
            if x < m - 2:
                if grid[y][x+1] == '.' and grid[y][x+2] == '.':
                    if x == 0:
                        clues += 1
                        clue_loc[y][x] = True
                    
                    elif grid[y][x-1] == '#':
                        clues += 1
                        clue_loc[y][x] = True
                    
            #vertical-----------------------------------------
            if not clue_loc[y][x] and y < n - 2:
                if grid[y+1][x] == '.' and grid[y+2][x] == '.':
                    if y == 0:
                        clues += 1
                        clue_loc[y][x] = True
                
                    elif grid[y-1][x] == '#':
                        clues += 1
                        clue_loc[y][x] = True
            
print(clues)

for i in range(n):
    for j in range(m):
        if clue_loc[i][j]:
            print(i+1,j+1)
            