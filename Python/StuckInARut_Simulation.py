#only passes 6 test cases

#move the cows----------------------
def move():
    if cows[j][0] == 'E':
        locX[j] = cows[j][1] + i
    elif cows[j][0] == 'W':
        locX[j][j] = cows[j][1] - i
    elif cows[j][0] == 'N':
        locY[j] = cows[j][2] + i
    elif cows[j][0] == 'S':
        locY[j] = cows[j][2] - i
    

    if field[locX[j]][locY[j]]:
        cows[j] = False
    else:
        eaten[j] += 1
    return 0

#take inputs------------------------------------------------------
n = int(input())
cows = [0] * n
locX = [0] * n
locY = [0] * n
eaten = [1] * n

for i in range(n):
    cows[i] = input().split()
    cows[i][1] = int(cows[i][1]); cows[i][2] = int(cows[i][2])
    locX[i] = cows[i][1]; locY[i] = cows[i][2]

#make field------------------------------------------------------
field = [False] * (1000 + max(locX))
for i in range(len(field)):
    field[i] = [False] * (1000 + max(locY))

#simulate cow movement----------------------
for i in range(1, 1000):
    for j in range(n):
        if cows[j]:
            move()
    for j in range(n):
        field[locX[j]][locY[j]] = True

#print----------------------------------
for i in range(n):
    if eaten[i] == 1000:
        print('Infinity')
    else:
        print(eaten[i])
    