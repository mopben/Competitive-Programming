import sys
sys.stdin = open("bcount.in","r")
sys.stdout = open("bcount.out","w")

n,q = map(int,input().split())

cows = []

for i in range(n):
    cows.append(int(input()))

breed1 = [0]; breed2 = [0]; breed3 = [0]
counter1 = 0; counter2 = 0; counter3 = 0
for i in range(n):
    if cows[i] == 1:
        counter1 += 1
    if cows[i] == 2:
        counter2 += 1
    if cows[i] == 3:
        counter3 += 1
    breed1.append(counter1)
    breed2.append(counter2)
    breed3.append(counter3)

    

for i in range(q):
    a,b = map(int,input().split())
    a -= 1
    num1 = breed1[b] - breed1[a]
    num2 = breed2[b] - breed2[a]
    num3 = breed3[b] - breed3[a]
    print(num1,num2,num3)