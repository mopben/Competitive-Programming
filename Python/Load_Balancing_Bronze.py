import sys
sys.stdin = open("balancing.in","r")
sys.stdout = open("balancing.out","w")

n,b = map(int, input().split())

cows = [0] * n
sortedX = [0] * n
sortedY = [0] * n
for i in range(n):
    cows[i] = input().split()
    cows[i][0] = int(cows[i][0]); cows[i][1] = int(cows[i][1])
    sortedX[i] = cows[i][0]; sortedY[i] = cows[i][1]

sortedX.sort()
sortedY.sort()

northEast = 0
northWest = 0
southEast = 0
southWest = 0
m = n
for i in range(n):
    for j in range(n):
        x = cows[i][0] + 1; y = cows[j][1] + 1
        northEast = 0; northWest = 0; southEast = 0; southWest = 0
        for k in range(n):
            if cows[k][0] >  x and cows[k][1] > y:
                northEast += 1
            elif cows[k][0] > x and cows[k][1] < y:
                northWest += 1
            elif cows[k][0] < x and cows[k][1] > y:
                southEast += 1
            elif cows[k][0] < x and cows[k][1] < y:
                southWest += 1
        m = min(max(northEast, northWest, southEast, southWest),m)

print(m)