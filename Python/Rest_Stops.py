import sys

sys.stdin = open("reststops.in","r")
sys.stdout = open("reststops.out","w")

def comp0(arr):
    return arr[0]
l,n,f,b = map(int,input().split())

stops = [0] * n
for i in range(n):
    stops[i] = input().split()
    stops[i][0] = int(stops[i][0]); stops[i][1] = int(stops[i][1])
    
goodStop = [False] * n
goodStop[n-1] = True

stops.sort(key = comp0)
big = stops[n-1][1]
location = 0

for i in reversed(range(n-1)):
    if stops[i][1] > big:
        big = stops[i][1]; goodStop[i] = True
        
farmer = 0
bessie = 0
time = 0
lastLocation = 0
ans = 0
for i in range(n):
    if goodStop[i]:
        time += b * (stops[i][0] - lastLocation)
        bessie = stops[i][0]
        farmer = (stops[i][0] - lastLocation) * f
        bessie = (stops[i][0] - lastLocation) * b
        ans += (farmer - bessie)*(stops[i][1])
        bessie = farmer
        lastLocation = stops[i][0]
        
print(int(ans))