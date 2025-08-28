import sys

def comp0(arr):
    return arr[0]

sys.stdin = open("socdist2.in","r")
sys.stdout = open("socdist2.out","w")

n = int(input())
cows = [0] * n

for i in range(n):
    cows[i] = input().split()
    cows[i][0] = int(cows[i][0]); cows[i][1] = int(cows[i][1])
    
cows.sort(key = comp0)

counter = 0

#find r+1-------------------------------------
r = 9999999999; lastLoc = -1

for i in range(n):
    if cows[i][1] == 1:
        lastLoc = cows[i][0]
    elif lastLoc != 1:
        r = min(r, cows[i][0] - lastLoc)

#check forward------------------------------------
for i in range(n-1):
    if cows[i][1] == 0 and cows[i+1][1] == 1:
        r = min(r, cows[i+1][0] - cows[i][0])
        
sick = 1

#count groups----------------------------------------
for i in range(1,n):
    if cows[i][1] == 1:
        if cows[i-1][1] == 0:
            sick += 1
        elif cows[i][0] - cows[i-1][0] >= r:
            sick += 1


print(sick)
        
    