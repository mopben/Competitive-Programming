import sys

sys.stdin = open("trapped.in","r")
sys.stdout = open("trapped.out","w")

def comp(arr):
    return arr[1]

n = int(input())

bales = [0] * n
for i in range(n):
    bales[i] = [int(x) for x in input().split()]

bales.sort(key = comp)

area = bales[n-1][1] - bales[0][1]

for i in range(1,n):
    a = i; b = i - 1
    escaped = False; trapped = False
    while not escaped and not trapped:
        if (bales[a][1] - bales[b][1]) > bales[a][0]:
            if a == n-1:
                escaped = True
                
            if a != n-1:
                a += 1
                
        if (bales[a][1] - bales[b][1]) > bales[b][0]:
            if b == 0:
                escaped = True
                
            if b != 0:
                b -= 1

        if (bales[a][1] - bales[b][1]) <= bales[a][0] and (bales[a][1] - bales[b][1]) <= bales[b][0]:
            trapped = True
        
    if escaped:
        area -= bales[i][1] - bales[i-1][1]
                

print(area)
