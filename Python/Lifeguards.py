#fin = open("lifeguards.in","r")
#fout = open("lifeguards.out","w")

def comp0(arr):
    return arr[0]

maxTime = 0
n = int(input())
#n = int(fin.readline())
shifts = [0] * n

for i in range(n):
    shifts[i] = [0] * 2

for i in range(n):
    start,end = input().split()
    #start,end = fin.readline().split()
    start = int(start); end = int(end)
    shifts[i][0] = start; shifts[i][1] = end

tempShifts = [0]

#fire every worker to find highest time covered--------------------------------------
for a in range(n):
    timeCovered = 0
    tempShifts.clear()
    tempShifts = [0] * n
    for b in range(n):
        tempShifts[b] = [0] * 2
        for c in range(2):
            tempShifts[b][c] = shifts[b][c]
    #fire worker and sort--------------------------------------------------
    tempShifts.pop(a)
    tempShifts.sort(key = comp0)
    
    #find time covered after worker fired-------------------------------------
    for i in range(n-2):
        if tempShifts[i][1] < tempShifts[i+1][0]:
            timeCovered += tempShifts[i][1] - tempShifts[i][0]
        else:
            timeCovered += tempShifts[i+1][0] - tempShifts[i][0]
    timeCovered += tempShifts[n-2][1] - tempShifts[n-2][0]
    
    if timeCovered > maxTime:
        maxTime = timeCovered

#fout.write(str(maxTime))
#fout.close()
print(maxTime)