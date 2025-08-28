import sys

sys.stdin = open("factory.in","r")
sys.stdout = open("factory.out","w")
#depth first search---------------------------
def dfs(node):
    visited = []
    visited.append(node)
    belts[node] = list(belts[node])
    
    for j in range(len(belts[node])):
        if belts[node][j] not in visited:
            visCount[belts[node][j]-1] += 1
            if belts[node][j] in belts:
                dfs(belts[node][j])
    return 0

#inputs-------------------------------------
n = int(input())

belts = dict()

#make adjacency list-------------------------
for i in range(n-1):
    a,b = input().split()
    a = int(a); b = int(b)
    if a in belts:
        belts[a].update(set([b]))
    else:
        belts.update({a: set([b])})


visCount = [0] * n

#calculate how many stations can reach eachother
for i in range(1,n+1):
    if i in belts:
        dfs(i)

#find and print answer----------------------------
for i in range(n):
    if visCount[i] == n-1:
        print(i+1)
        sys.exit()

print(-1)