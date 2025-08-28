import sys

sys.stdin = open("cownomics.in","r")
sys.stdout = open("cownomics.out","w")

#brute force----------------------------------------

n,m = input().split()
n = int(n)
m = int(m)
spotty = [''] * n
plain = [''] * n
counter = 0
for i in range(n):
    spotty[i] = input()
for i in range(n):
    plain[i] = input()
#process------------------------------------------------------------------------

for col in range(m):
    flag = 1
    for rowS in range(n):
        firstLetter = spotty[rowS][col]
        for rowP in range(n):
            secondLetter = plain[rowP][col]
            if firstLetter == secondLetter:
                flag = 0
                break
                
    if flag == 1:
        counter += 1

print(counter)
    