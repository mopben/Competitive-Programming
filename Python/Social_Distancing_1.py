import sys

#place cow in half of the biggest space----------------------

def findGap(stall):
    biggestGap = 0; curStart = -1; counter3 = 0; loc1 = 0; loc2 = 0
    for i in range(n):
        if stall[i] == '1':
            if counter3 > biggestGap and curStart != -1:
                biggestGap = counter3
                loc1 = curStart; loc2 = i
            curStart = i
            counter3 = 0
        else:
            counter3 += 1

    if counter3 > biggestGap and curStart != -1:
        biggestGap = counter3
        loc1 = curStart; loc2 = i
    return loc1, loc2, biggestGap
            
            
def place(s):
    gapStart2, gapEnd2, largestGap2 = findGap(s)
    if largestGap >= 2:
        s[(gapStart2 + gapEnd2) // 2] = '1'
        return findMin(s)
    
    return -1
    
def findMin(s):
    minCounter = 1000000
    counter2 = 1000000
    prevJ = 0
    for j in range(n):
        if s[j] == '1':
            if counter2 < minCounter:
                minCounter = counter2
                d = j - prevJ

            counter2 = 0
            prevJ = j
        else:
            counter2 += 1
    return d

sys.stdin = open("socdist1.in","r")
sys.stdout = open("socdist1.out","w")
n = int(input())
S = input()
stalls = []
for i in range(n):
    stalls.append(S[i])

counter = 0; maxCounter = 0; prevI = 0
gapStart, gapEnd, largestGap = findGap(stalls)

ans = 0
if largestGap >= 3:
    tempS = stalls.copy()
    tempS[(gapStart + gapEnd) // 3] = '1'
    tempS[(gapStart + gapEnd) * 2 // 3] = '1'
    ans = max(ans, findMin(tempS))

if stalls[0] == '0' and stalls[n-1] == '0':
    tempS = stalls.copy()
    tempS[0] = '1'; tempS[n-1] = '1'
    ans = max(ans, findMin(tempS))
    
if stalls[0] == '0':
    tempS = stalls.copy()
    tempS[0] = '1'
    ans = max(ans, place(tempS))
    
if stalls[n-1] == '0':
    tempS = stalls.copy()
    tempS[n-1] = '1'
    ans = max(ans, place(tempS))

if largestGap >= 2:
    tempS = stalls.copy()
    tempS[(gapStart + gapEnd)// 2] = '1'
    ans = max(ans, place(tempS))

print(ans)

