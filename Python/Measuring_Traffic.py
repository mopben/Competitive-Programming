import sys

sys.stdin = open("traffic.in","r")
sys.stdout = open("traffic.out","w")


n = int(input())

segments = [0] * n
rateMin = -9999999999
rateMax = 9999999999

for i in range(n):
    segments[i] = input().split()
    segments[i][1] = int(segments[i][1]); segments[i][2] = int(segments[i][2])
    

#determine before----------------------------------
none = bool(0)
for i in reversed(range(0,n-1)):
    if segments[i][0] == 'none':
        rateMin = max(segments[i][1], rateMin)
        rateMax = min(segments[i][2], rateMax)
    if segments[i][0] == 'off':
        rateMin += segments[i][1]
        rateMax += segments[i][2]
    if segments[i][0] == 'on':
        rateMin -= segments[i][2]
        rateMax -= segments[i][1]
        rateMin = max(0,rateMin)


    
print(rateMin, rateMax)

rateMin = -9999999999
rateMax = 9999999999
    
#determine after-----------------------------------
for i in range(n):
    if segments[i][0] == 'none':
        rateMin = max(segments[i][1], rateMin)
        rateMax = min(segments[i][2], rateMax)
    if segments[i][0] == 'off':
        rateMin -= segments[i][2]
        rateMax -= segments[i][1]
        rateMin = max(0,rateMin)
    if segments[i][0] == 'on':
        rateMin += segments[i][1]
        rateMax += segments[i][2]

    
print(rateMin, rateMax)
        