import sys

sys.stdin = open("reduce.in","r")
sys.stdout = open("reduce.out","w")

def findCord(arr):
    location = [0] * n
    minX = 40001; minY = 40001; maxX = 0; maxY = 0
    for i in range(len(arr)):
        if arr[i][0] < minX:
            minX = arr[i][0]
            location[0] = i
        
        if arr[i][1] < minY:
            minY = arr[i][1]
            location[1] = i
        
        if arr[i][0] > maxX:
            maxX = arr[i][0]
            location[2] = i
    
        if arr[i][1] > maxY:
            maxY = arr[i][1]
            location[3] = i
    
    return minX, minY, maxX, maxY, location

n = int(input())

cows = [0] * n

for i in range(n):
    cows[i] = [int(x) for x in input().split()]

x1,y1,x2,y2,loc = findCord(cows)

area = 9999999999
for k in range(4):
    tempCows = cows.copy()
    tempCows.pop(loc[k])
    x1,y1,x2,y2,placeholder = findCord(tempCows)
    area = min(area, (x2-x1)*(y2-y1))


print(area)

