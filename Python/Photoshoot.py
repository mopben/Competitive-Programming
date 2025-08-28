import sys

sys.stdin = open("photo.in","r")
sys.stdout = open("photo.out","w")

n = int(input())
b = input().split()
for i in range(n-1):
    b[i] = int(b[i])



for i in range(1,n):
    a = [0] * n; a[0] = i
    visit = [False] * n; visit[i-1] = True
    for j in range(1,n):
        a[j] = b[j-1] - a[j-1]
        if a[j] > n:
            break
        visit[a[j]-1] = True
    
    if False in visit:
        pass
    else:
        for i in range(n-1):
            print(a[i], end = ' ')
        print(a[n-1])
        sys.exit()
        