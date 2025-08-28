import sys

sys.stdin = open("cow.in","r")
sys.stdout = open('cow.out','w')
n = int(input())
s = input()

c = 0; o = 0; w = 0
ans = 0; counter = 0
for i in range(n):
    if s[i] == 'C':
        c += 1
    if s[i] == 'O':
        o += 1
        if c > 0:
            counter += c
    if s[i] == 'W':
        if c > 0 and o > 0:
            ans += counter

print(ans)
