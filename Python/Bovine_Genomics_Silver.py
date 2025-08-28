#python is too slow to pass 2 of the test cases

import sys

sys.stdin = open("cownomics.in","r")
sys.stdout = open("cownomics.out","w")

def findLetters(lst):
    letters = [0] * m
    for i in range(m):
        if lst[i] == 'A':
            letters[i] = 0
        elif lst[i] == 'C':
            letters[i] = 1
        elif lst[i] == 'G':
            letters[i] = 2
        elif lst[i] == 'T':
            letters[i] = 3
    return letters

def test():
    mark = [0] * 64
    increase = True
    for a in range(n):
        mark[s1[a][i]*16 + s1[a][j]*4 + s1[a][k]] = 1
    for a in range(n):
        if mark[p1[a][i]*16 + p1[a][j]*4 + p1[a][k]]:
            increase = False
    return increase
        
n,m = map(int,input().split())

s = [''] * n
p = [''] * n
for i in range(n):
    s[i] = input()
for i in range(n):
    p[i] = input()


s1 = [0] * n
p1 = [0] * n

for i in range(n):
    s1[i] = findLetters(s[i])
    p1[i] = findLetters(p[i])

ans = 0


for i in range(m):
    for j in range(i+1,m):
        for k in range(j+1,m):
            if test():
                ans += 1
                
                
print(ans)