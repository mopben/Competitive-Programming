import sys

sys.stdin = open("taming.in","r")
sys.stdout = open("taming.out","w")

def inconsistent():
    print(-1)
    sys.exit()
    
n = int(input())

breakouts = [int(x) for x in input().split()]

breakoutMin = 0
breakoutMax  = 0
lastCounters = [0] * n

#find all avaliable breakout counters---------------------------------
for i in range(1,n):
    if breakouts[i] != -1:
        lastCounters[i] = breakouts[i]

        for j in reversed(range(i-lastCounters[i]-1,i)):

            if i - breakouts[i] < 0 or lastCounters[i - breakouts[i]] > 0 :
                inconsistent()
            if lastCounters[j] == -1:
                lastCounters[j] = j - (i - lastCounters[i] )

    else:
        lastCounters[i] = -1


            
#find max and min breakouts--------------------------------------
for i in range(n):
    if lastCounters[i] == 0:
        breakoutMin += 1
    if lastCounters[i] == -1:
        breakoutMax += 1


print(breakoutMin, breakoutMin + breakoutMax)
    