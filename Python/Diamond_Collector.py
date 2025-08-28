import sys

sys.stdin = open("diamond.in","r")
sys.stdout = open("diamond.out","w")

n, k = map(int, input().split())

diamonds = []
for i in range(n):
    diamonds.append(int(input()))

maxCounter = 0
for i in range(n):
    counter = 0
    for j in range(n):
        if diamonds[j] >= diamonds[i] and diamonds[j] <= diamonds[i] + k:
            counter += 1
    
    maxCounter = max(maxCounter, counter)

print(maxCounter)
    
            