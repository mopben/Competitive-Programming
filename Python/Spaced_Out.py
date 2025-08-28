import copy

n = int(input())

grid = [0] * n
loc = [0] * n
for i in range(n):
    loc[i] = [0] * n
    grid[i] = [int(x) for x in input().split()]

ans = 0; ans2 = 0; ans3 = 0; ans4 = 0
grid_2 = copy.deepcopy(grid)
grid_3 = copy.deepcopy(grid)
grid_4 = copy.deepcopy(grid)
for y in range(n):
    for x in range(n):
        
        if y != 0:
            if grid[y-1][x] != -1:
                ans += grid[y][x]
                grid[y][x] = -1
        else:
            ans += grid[y][x]
            grid[y][x] = -1
        
        if x != 0:
            if grid_2[y][x-1] != -1:
                ans2 += grid_2[y][x]
                grid_2[y][x] = -1
        else:
            ans2 += grid_2[y][x]
            grid_2[y][x] = -1
        
        if x == 1:
            ans3 += grid_3[y][x]
            grid_3[y][x] = -1
            
        elif x != 0:
            if grid_3[y][x-1] != -1:
                ans += grid_3[y][x]
                grid_3[y][x] = -1
        
        if y == 1:
            ans3 += grid_4[y][x]
            grid_4[y][x] = -1
            
        elif y != 0:
            if grid_4[y-1][x] != -1:
                ans3 += grid_4[y][x]
                grid_4[y][x] = -1
                
print(max(ans,ans2,ans3,ans4))
