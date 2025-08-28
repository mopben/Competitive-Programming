import sys

def cycle(start):
    counter = 0
    d = start
    stop = False
    
    while not stop:
        counter += 1
        visited[d] = True
        
        d = loc[a[d]]
        if d == start:
            stop = True
           
    return counter

sys.stdin = open("reorder.in","r")
sys.stdout = open("reorder.out","w")
n = int(input())

a = []
for i in range(n):
    a.append(int(input()))

b = []

for i in range(n):
    b.append(int(input()))
    
loc = [0] * (n+1)

for i in range(n):
    loc[b[i]] = i

cycles = 0; longest = 0

original = a.copy()
visited = [False] * n
for i in range(n):
    if a[i] != b[i] and not visited[i]:
        length = cycle(i)
        longest = max(longest,length)
        cycles += 1

if cycles == 0:
    print(cycles,-1)
else:
    print(cycles,longest)