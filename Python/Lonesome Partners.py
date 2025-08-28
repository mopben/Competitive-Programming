import math
# THIS SCRIPT IS OUTDATED AND INCORRET FOR THE USACO PROBLEM IN QUESTION

n = int(input())
maxDist = 0
maxCow = [0]*n

cowsX = [] * n
cowsY = [] * n
cows = [] * n
for i in range(n):
    cows.append(input().split())
    cowsX.append(cows[0][0])
    cowsY.append(cows[0][1])
    I = i+1
    for (I) in range(n):
        for j in range(I):
            distance = math.sqrt( ((int(cowsX[I-1])-int(cowsX[j]))**2)+((int(cowsY[I-1])-int(cowsY[j]))**2) )
            if distance > maxDist:
                maxDist = distance
                maxCowi = I
                maxCowj = j+1
    cows = []
print(maxCow)