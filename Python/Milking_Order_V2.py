def check():
    counter = 0

    
n,m,k = map(int,input().split())
ordering = [int(x)-1 for x in input().split()]
    
pos = [0] * k; cow = [0] * k

order = [False] * n; milked = [False] * n
loc = [0] * n
for i in range(k):
    cow,fixed = map(int,input().split())
    cow -= 1; fixed -= 1
    order[fixed] = True; milked[cow] = True

for i in range(n):
    O = order.copy(); M = milked.copy()
    if not O[i]:
        O[i] = False; M[0] = False
        if check():
            print(i+1)
            break
    
    
