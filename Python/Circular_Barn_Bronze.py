import sys

sys.stdin = open("cbarn.in","r")
sys.stdout = open("cbarn.out","w")

n = int(input())
doors = [0] * n

cows = 0
for i in range(n):
    doors[i] = int(input())
    cows += doors[i]

minDis = 9999999999

for i in range(n):
    dis = 0; barn = [0] * n
    for j in range(n):
        dis += doors[(i+j)%n] * j
             
    minDis = min(minDis,dis)
    
print(minDis)
        