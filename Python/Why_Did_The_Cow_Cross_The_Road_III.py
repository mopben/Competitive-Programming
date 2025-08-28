import sys

sys.stdin = open("cowqueue.in","r")
sys.stdout = open("cowqueue.out","w")

def comp(c):
    return c[0]
    

#inputs and variables
n = int(input())
cows = [0] * n

for i in range(n):
    cows[i] = [0] * 2
    arriveT,duration = input().split()
    arriveT = int(arriveT)
    duration = int(duration)
    
    cows[i][0] = arriveT
    cows[i][1] = duration

cows.sort(key = comp)
curTime = 0
#process
for i in range(n):
    if cows[i][0] > curTime:
        curTime = cows[i][0]
    curTime += cows[i][1]
print(curTime)