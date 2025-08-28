import sys

sys.stdin = open("cowroute.in","r")
sys.stdout = open("cowroute.out","w")

a,b,n = map(int,input().split())

feasible = []
for i in range(n):
    cost,cities = map(int,input().split())
    route = [int(x) for x in input().split()]
    if a in route and b in route:
        if route.index(a) < route.index(b):
            feasible.append(cost)
        
if len(feasible) == 0:
    print(-1)
else:
    print(min(feasible))
