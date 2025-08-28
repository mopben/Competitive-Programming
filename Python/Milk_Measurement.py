import sys

sys.stdin = open("measurement.in","r")
sys.stdout = open("measurement.out","w")

def comp0(c):
    return c[0]

n = int(input())

counter = 0
cows = [0] * n
#get inputs----------------------------------------------------------------------

for i in range(n):
    cows[i] = input().split()
    cows[i][0] = int(cows[i][0])
cows.sort(key = comp0)
    
totalMilk = [7] * 3 # 0 = B, 1 = E, 2 = M

bessieOn = bool(1); elsieOn = bool(1); mildredOn = bool(1)
#calculate totalMilk------------------------------------------------------------

for i in range(n):
    change = cows[i][2]
    
#change milk production---------------------------------------------------------

    if cows[i][1] == 'Bessie':
        if change[0] == '-':
            totalMilk[0] -= int(change[1])
        elif change[0] == '+':
            totalMilk[0] += int(change[1])
            
    if cows[i][1] == 'Elsie':
        if change[0] == '-':
            totalMilk[1] -= int(change[1])
        elif change[0] == '+':
            totalMilk[1] += int(change[1])
            
    if cows[i][1] == 'Mildred':
        if change[0] == '-':
            totalMilk[2] -= int(change[1])
        elif change[0] == '+':
            totalMilk[2] += int(change[1])
    
    maxValue = max(totalMilk)

    
    #change who's on display
    bessieNext = totalMilk[0] == maxValue
    elsieNext = totalMilk[1] == maxValue
    mildredNext = totalMilk[2] == maxValue
    
    if bessieNext != bessieOn or elsieNext != elsieOn or mildredNext != mildredOn:
        counter += 1
    
    bessieOn = bessieNext
    elsieOn = elsieNext
    mildredOn = mildredNext

print(counter)