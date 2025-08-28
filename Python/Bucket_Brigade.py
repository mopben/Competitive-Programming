import sys

sys.stdin = open("buckets.in","r")
sys.stdout = open("buckets.out","w")
farm = [0] * 10

for i in range(10):
    farm[i] = input().split()

for i in range(10):
    for j in range(10):
        line = farm[i][0]
        if line[j] == 'B' :
            BcordY = i; BcordX = j
        if line[j] == 'L':
            LcordY = i; LcordX = j
        if line[j] == 'R':
            RcordY = i; RcordX = j
            

disBr = abs(BcordY - RcordY) + abs(BcordX - RcordX)
disBl = abs(BcordY - LcordY) + abs(BcordX - LcordX)
disLr = abs(LcordY - RcordY) + abs(LcordX - RcordX)

if (BcordY==LcordY or BcordX==LcordX) and disBl == disBr + disLr:
    print(disBl+1)
else:
    print(disBl-1)

