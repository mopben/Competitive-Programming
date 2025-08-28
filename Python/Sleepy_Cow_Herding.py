import sys

sys.stdin = open("herding.in","r")
sys.stdout = open("herding.out","w")


b,e,m = map(int,input().split())

sortedCows = [b,e,m]

sortedCows.sort()
minMoves = 0
maxMoves = 0

#minimum moves possible---------------------------------
if sortedCows[2] - sortedCows[1] == 1 and sortedCows[1] - sortedCows[0] == 1:
    print(0)
elif sortedCows[2] - sortedCows[1] == 2 or sortedCows[1] - sortedCows[0] == 2:
    print(1)
else:
    print(2)
    
print(max(sortedCows[2] - sortedCows[1], sortedCows[1] - sortedCows[0]) - 1)