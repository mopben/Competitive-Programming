def valid(Y,X):
    if X >= 0 and X <= n and Y >= 0 and Y <= n and field[Y][X]:
        return True
    return False
def check(a,b):
    counter = 0
    if valid(a+1,b):
        if field[a+1][b]:
            counter += 1
    if valid(a-1,b):
        if field[a-1][b]:
            counter += 1
    if valid(a,b+1):
        if field[a][b+1]:
            counter += 1
    if valid(a,b-1):
        if field[a][b-1]:
            counter += 1
    
    return counter == 3

n = int(input())
field = [0] * 1002
for i in range(len(field)):
    field[i] = [0] * len(field)
    
comf = 0
for i in range(n):
    ans1 = 0; ans2 = 0
    x,y = map(int,input().split())

    if valid(y+1,x):
        if check(y+1,x):
            comf -= 1
    if valid(y,x+1):
        if check(y,x+1):
            comf -= 1
    if valid(y-1,x):
        if check(y-1,x):
            comf -= 1
    if valid(y,x-1):
        if check(y,x-1):
            comf -= 1
            
    field[y][x] = True
    
    if check(y,x):
        comf += 1
        
    if valid(y+1,x):
        if check(y+1,x):
            comf += 1
    if valid(y,x+1):
        if check(y,x+1):
            comf += 1
    if valid(y-1,x):
        if check(y-1,x):
            comf += 1
    if valid(y,x-1):
        if check(y,x-1):
            comf += 1

    print(comf)