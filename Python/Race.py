import sys

#sys.stdin = open("race.in","r")
#sys.stdout = open("race.out","w")

def checkMeters(a,b):
    total = (a+b)*(b-a+1)/2
    return total
def check(s,disLeft):
    if checkMeters(x+1, s-1) < disLeft:
        return True
    return False

k, n = map(int,input().split())

for i in range(n):
    distance = 0
    speed = 0
    time = 0
    x = int(input())
    
    distLeft = k
    #simulate running-------------------------------
    while distLeft > 0:
        if check(speed + 1, distLeft - (speed+1)):
            speed += 1
        elif check(speed, distLeft - speed):
            pass
        else:
            #check(speed - 1, distLeft - speed - 1)
            speed -= 1
            
        time += 1
        distLeft -= speed
        
print(end-start)