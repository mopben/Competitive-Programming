import sys

sys.stdin = open("cowroute.in","r")
sys.stdout = open("cowroute.out","w")

a,b,n = map(int,input().split())

single = []; route = [0] * n; cost = [0] * n; ind_b = [False] * n; ind_a = [-1] * n

for i in range(n):
    cost[i],cities = map(int,input().split())
    route[i] = [int(x) for x in input().split()]
    
    if b in route[i]:
        ind_b[i] = route[i].index(b)
    
    if a in route[i]:
        ind_a[i] = route[i].index(a)
        
    if a in route[i] and b in route[i]:
        if route[i].index(a) < route[i].index(b):
            single.append(cost[i])

feasible = []
for i in range(n):
    for j in range(n):
        if ind_b[j] and i != j and ind_a[i] != -1:
            cit1 = set(route[i][ind_a[i]:len(route[i])]); cit2 = set(route[j][0:(ind_b[j])])

            if cit1.intersection(cit2):
                feasible.append(cost[i] + cost[j])
                
if len(feasible) > 0 and len(single) > 0:
    print(min(min(feasible),min(single)))
    sys.exit()

if len(single) > 0 and len(feasible) == 0:
    print(min(single))
    sys.exit()
    
if len(feasible) > 0 and len(single) == 0:
    print(min(feasible))
    sys.exit()
    
print(-1)
