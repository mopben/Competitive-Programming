import sys

sys.stdin = open("baseball.in","r")
sys.stdout = open("baseball.out","w")
def binary_search(v):
    low = 0; high = n
    while low < high:
        mid = (low + high) //2
        if cows[mid] < v:
            low += 1
        else:
            high = mid
    return low

def find_cows(c1,c2):
    return binary_search(c2+1) - binary_search(c1) 

n = int(input())
cows = []
for i in range(n):
    cows.append(int(input()))

cows.sort()
ans = 0
for i in range(n):
    for j in range(i+1,n):
        ans += find_cows(cows[j] + (cows[j] - cows[i]),cows[j] + ((cows[j] - cows[i])*2))

print(ans)