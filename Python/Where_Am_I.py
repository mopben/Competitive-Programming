import sys

sys.stdin = open("whereami.in","r")
sys.stdout = open("whereami.out","w")

n = int(input())

farms = input()

for k in range(1,n):
    seen = set()
    invalid = False
    for i in range(n-k+1):
        if farms[i:i+k] in seen:
            invalid = True
            break
        else:
            seen.add(farms[i:i+k])

    if not invalid:
        print(k)
        break