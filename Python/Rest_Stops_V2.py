import sys
sys.stdin = open("reststops.in","r")
sys.stdout = open("reststops.out","w")

def comp0(arr):
    return arr[0]

l,n,r_f,r_b = map(int,input().split())

stops = []
for i in range(n):
    stops.append([int(x) for x in input().split()])


stops.sort(key = comp0)

most = []
max_t = 0
for i in reversed(range(n)):
    if stops[i][1] > max_t:
        most.append(stops[i])
        max_t = stops[i][1]

most.reverse()
loc = 0; ans = 0
for i in range(len(most)):
    dis = most[i][0] - loc
    ans += (most[i][1] * ((r_f * dis) - (r_b * dis)))
    loc = most[i][0]
    
print(ans)