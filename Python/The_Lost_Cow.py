import sys

sys.stdin = open("lostcow.in","r")
sys.stdout = open("lostcow.out","w")

x,y = map(int,input().split())

add = ''
counter = 0
addCounter = 1
distance = 0
tempX = x
firstLoop = bool(1)
#simluate-------------------------
while True:
    if (tempX >= y and add == 'no' and x <= y) or (tempX <= y and add == 'yes' and x >= y) or (tempX == y): 
        distance -= abs(tempX - y)
        break
    
    if firstLoop:
        add = 'yes'
        firstLoop = bool(0)
    
    if add == 'yes':
        add = 'no'
        distance += abs(tempX - (x + addCounter))
        tempX = x + addCounter
        addCounter *= 2
    else:
        add = 'yes'
        distance += abs(tempX - (x - addCounter))
        tempX = x - addCounter
        addCounter *= 2
        
        
            
print(distance)


    