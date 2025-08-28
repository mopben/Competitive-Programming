
k,n = map(int,input().split())

s = [int(x) for x in input().split()]

v = [int(x) for x in input().split()]

sums = [0]
for i in range(k):
    sums.append(sums[i] + s[i])

possible = set()

for i in range(1,k+1):
    possible.add(v[0] - sums[i])

ans = 0
for start in possible:
    seen = set()
    for i in range(k):
        start += s[i]
        if start in v:
            seen.add(start)
    
    if len(seen) == len(v):
        ans += 1

print(ans)