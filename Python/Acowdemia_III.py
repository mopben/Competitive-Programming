def check(x,y,ignore):
    if x > 0 and ignore != 'left':
        if grid[y][x-1] == 'C':
            return True,'left',(x-1,y)
    
    if x < m-1 and ignore != 'right':
        if grid[y][x+1] == 'C':
            return True,'right',(x+1,y)
    
    if y > 0 and ignore != 'up':
        if grid[y-1][x] == 'C':
            return True,'up',(x,y-1)
    
    if y < n-2 and ignore != 'down':
        if grid[y+1][x] == 'C':
            return True,'down',(x,y+1)
    
    return False,'asdf','asdf'

n,m = map(int,input().split())

grid = [0] * n
grass = []
pot_friends = dict()
for i in range(n):
    s = input()
    grid[i] = [0] * m
    for j in range(m):
        grid[i][j] = s[j]

        if grid[i][j] == 'G':
            grass.append((j,i))
    
for i in grass:
    pot_friends[i] = set()

used = dict()
for i in range(len(grass)):
    cond, direction, cow1 = check(grass[i][0],grass[i][1],None)
    if cond:
        cond,direction,cow2 = check(grass[i][0],grass[i][1],direction)
        if cond:
            if frozenset({cow1,cow2}) not in used:
                used[frozenset({cow1,cow2})] = 0
            pot_friends[grass[i]].add(frozenset({cow1,cow2}))
            used[frozenset({cow1,cow2})] += 1

ans = 0
for i in used.keys():
    if used[i] > 1:
        amount = []
        index = []
        for j in pot_friends.keys():
            if i in pot_friends[j]:
                amount.append(len(j))
                index.append(j)
        
        while used[i] > 1:
            used[i] -= 1
            pot_friends[index[amount.index(max(amount))]].remove(frozenset(i))
            
for j in pot_friends.keys():
    if len(pot_friends[j]) > 0:
        ans += 1

print(ans)