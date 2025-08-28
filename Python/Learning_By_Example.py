import sys
#sys.stdin = open("learning.in","r")
#sys.stdout = open("learning.out","w")

def comp1(arr):
    return arr[1]

n,a,b = map(int,input().split())

cows = [0] * n

for i in range(n):
    cows[i] = input().split()
    cows[i][1] = int(cows[i][1])

cows.append(['NS',-100000000000000000000])
cows.append(['NS',1000000000000000000000])
cows.sort(key = comp1)

ans = 0
for i in range(0,len(cows)-1):
    m = (cows[i+1][1] + cows[i][1] ) // 2
    
    if cows[i][0] == 'S':
        temp1 = max(a,cows[i][1]+1)
        temp2 = min(b,m)
        if temp2 >= temp1:
            ans += temp2 - temp1 + 1
    
    print(i, ans)
    if cows[i+1][0] == 'S':
        temp1 = max(a,m+1)
        temp2 = min(b, cows[i+1][1])
        if temp2 >= temp1:

            ans += temp2 - temp1 + 1

    print(i, ans)
    if cows[i][0] == 'NS' and cows[i+1][0] == 'S' and (cows[i][1] % 2) == (cows[i+1][1] % 2) and a <= m and m <= b:
        ans += 1
    

print(int(ans))