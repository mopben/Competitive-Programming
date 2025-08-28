n = int(input())

for i in range(n):
    p1,p2 = input().split()
    p1 = int(p1)
    p2 = int(p2)
    
    if (p1 == 1 and p2 == 2) or (p1 == 2 and p2 == 3) or(p1 == 3 and p2 == 1):
        counter1 += 1
    elif (p1 == 1 and p2 == 3) or (p1 == 2 and p2 == 1) or (p1 == 3 and p2 == 2):
        counter2 += 1

if counter1 > counter2:
    maxCounter = counter1
if counter2 > counter1:
    maxCounter = counter2
if counter1 == counter2:
    maxCounter = counter1
    
    
print(maxCounter)
    