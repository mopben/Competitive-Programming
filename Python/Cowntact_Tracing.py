import sys

sys.stdin = open("tracing.in","r")
sys.stdout = open("tracing.out","w")

def comp0(arr):
    return arr[0]

n,t = map(int,input().split())

state = input()
sick = []
for i in range(n):
    if state[i] == '0':
        converter = False
    else:
        converter = True
    sick.append(converter)

records = [0] * t

for i in range(t):
    records[i] = input().split()
    records[i][0] = int(records[i][0]); records[i][1] = int(records[i][1]) - 1; records[i][2] = int(records[i][2]) - 1

records.sort(key = comp0)

#find patient zero and k's-------------------------------------------
patientZeros = [False] * (n + 1)
times = [False] * (t + 1)

for k in range(t+1):
    for i in range(n):
        cows = [False] * n #False for not infected, True for infected
        handShakes = [0] * n     
        cows[i] = True
        
        #simulate handshakes given patient zero and k----------------------------------------

        for j in range(t):
            x = records[j][1]
            y = records[j][2]
            if cows[x]:
                handShakes[x] += 1
            if cows[y]:
                handShakes[y] += 1
            if cows[x] and handShakes[x] <= k:
                cows[y] = True
            if cows[y] and handShakes[y] <= k:
                cows[x] = True
   
        if cows == sick:
            patientZeros[i] = True
            times[k] = True
            

maxK = 0; minK = 0
for i in range(t+1):
    if times[i]:
        maxK = i
        
for i in reversed(range(t+1)):
    if times[i]:
        minK = i 
    
if maxK == t:
    maxK = 'Infinity'
    
print(patientZeros.count(True), minK, maxK)
