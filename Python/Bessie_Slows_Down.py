import sys

sys.stdin = open("slowdown.in","r")
sys.stdout = open("slowdown.out","w")

n = int(input())
time = []
dis = []
for i in range(n):
    event,x = input().split()
    x = int(x)
    if event == 'T':
        time.append(x)
    if event == 'D':
        dis.append(x)


time.sort()
dis.sort()

speed = 1
loc = 0
ans = 0
time_d = 100000000000000000; time_t = 1000000000000000
while True:
    if len(time) > 0:
        time_t = time[0] - ans
    if len(dis) > 0:
        time_d = (dis[0]-loc) / (1/speed)
        
    if (time_t < time_d and len(time) > 0) or (len(dis) == 0 and len(time) > 0):
        loc += time_t * (1/speed)
        ans += time_t
        time.pop(0)
        
    elif len(dis) > 0:
        ans += time_d 
        loc = dis[0]
        dis.pop(0)

    else:
        ans += (1000 - loc) / (1/speed)
        break
    
    speed += 1

print(round(ans))