import sys

sys.stdin = open("decorate.in","r")
sys.stdout = open("decorate.out","w")
def dfs(node,color):
    global sign
    global counter
    
    if sign[node] != -1:
        return color != node
    
    if color:
        sign[node] = False
        counter[0] += 1
    else:
        sign[node] = True
        counter[1] += 1
    
    for k in graph[node]:
        if color:
            if not dfs(k,False):
                return False
        
        else:
            if not dfs(k,True):
                return False
    
    return True
        
#sys.stdin = open("decorate.in","r")
#sys.stdout = open("decorate.out","w")

n,m = map(int,input().split())

graph = dict()

for i in range(n):
    graph[i] = set()

for i in range(m):
    a,b = map(int,input().split())
    a -= 1; b -= 1
    graph[a].add(b)

signs = [True,False]
ans = 0

for i in range(n):
    counter = [0,0]
    visited = []; sign = [-1] * n #true = j, false = f
    
    if not dfs(i,False):
        ans = -1
    else:
        ans = max(counter)
        
if ans == -1:
    print(-1)
else:
    print(ans)