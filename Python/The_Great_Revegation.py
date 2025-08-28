import sys

sys.stdin = open("revegetate.in","r")
sys.stdout = open("revegetate.out","w")
n,m = map(int,input().split())

field = dict()

for i in range(m):
    p1,p2 = map(int,input().split())
    if p1 in field:
        field[p1].update(set([p2]))
    else:
        field.update({p1: set([p2])})
    if p2 in field:
        field[p2].update(set([p1]))
    else:
        field.update({p2: set([p1])})

color = [0] * n
for i in range(1,n+1):
    if i in field.keys():
        for j in range(1,5):
            stop = False
            for k in field[i]:
                if color[k-1] == j:
                    stop = True
            
            if not stop:
                color[i-1] = j
                break

    else:
        color[i-1] = 1
        
            
for i in range(n):
    print(color[i],end = '')

        