n,k = input().split()
n = int(n)
k = int(k)

for i in range(k):
    minutes = 0
    readPgs = 0
    curConsRead = 0
    totalT = 0
    cowSpeed,cowStamina,cowRest = input().split()
    cowSpeed = int(cowSpeed)
    cowStamina = int(cowStamina)
    cowRest = int(cowRest)
    while n > readPgs:
        if curConsRead == cowStamina:
            totalT += cowRest
            curConsRead = 0
        else:
            totalT += 1
            curConsRead += 1
            readPgs += cowSpeed
        
    print(totalT)
 