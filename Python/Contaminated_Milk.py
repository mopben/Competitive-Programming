import sys

sys.stdin = open("badmilk.in","r")
sys.stdout = open("badmilk.out","w")

n,m,d,s = map(int,input().split())

drink = [0] * d

for i in range(d):
    drink[i] = input().split()
    drink[i][0] = int(drink[i][0]); drink[i][1] = int(drink[i][1]); drink[i][2] = int(drink[i][2])

sick = [0] * s
for i in range(s):
    sick[i] = input().split()
    sick[i][0] = int(sick[i][0]); sick[i][1] = int(sick[i][1])

#find possible contaminated milk---------------------------------------------------
badMilk = [False] * m
for i in range(m):
    counter = 0
    alreadyDrank = [False] * n
    for j in range(d):
        for k in range(s):
            if drink[j][0] == sick[k][0] and drink[j][1] == i+1 and drink[j][2] < sick[k][1] and not alreadyDrank[k]:
                alreadyDrank[k] = True
                counter += 1
    if counter == s:
        badMilk[i] = True
        
#find number of people who drank bad milk-----------------------------------
ans = 0
for i in range(m):
    counter = 0
    if badMilk[i]:
        alreadyDrank = [False] * n
        for j in range(d):
            if not alreadyDrank[drink[j][0]-1] and drink[j][1] == i+1:
                counter += 1
                alreadyDrank[drink[j][0]-1] = True
        
        ans = max(ans, counter)
        
print(ans)