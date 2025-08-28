import math
import sys

sys.stdin = open("hoofball.in","r")
sys.stdout = open("hoofball.out","w")


countIsoGrp = 0
countZero = 0
n = int(input())

pos = input().split()
for i in range(n):
    pos[i] = int(pos[i])
pos.sort()
passToRight = [0] * n
getBall = [0] * n

#fill passToRight array------------------------------------------------------
passToRight[0] = bool(1)
passToRight[n-1] = bool(0)

for i in range(1,n-1):
    if abs(pos[i] - pos[i+1]) < abs(pos[i] - pos[i-1]):
        passToRight[i] = bool(1)
    else:
        passToRight[i] = bool(0)
#fill getBall----------------------------------------------------------------
if not passToRight[1]:
    getBall[0] += 1

if passToRight[n-2]:
    getBall[n-1] += 1
    
for i in range(1,n-1):
    if passToRight[i-1]:
        getBall[i] += 1
    if not passToRight[i+1]:
        getBall[i] += 1
        

for i in range(n):
    if getBall[i] == 0:
        countZero += 1


#count isolated---------------------------------------------------------------------

for i in range(n-1):
    if getBall[i] == 1 and getBall[i+1] == 1 and passToRight[i] and (not passToRight[i+1]):
        countIsoGrp += 1

print(countZero + countIsoGrp)

