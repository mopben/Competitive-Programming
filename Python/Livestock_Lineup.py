from itertools import permutations
import sys

def check_constraints(ordering):
    for j in c.keys():
        for k in range(8):
            if j == ordering[k]:
                counter = 0
                if k != 0:
                    if ordering[k-1] in c[j]:
                        counter += 1
                if k != 7:
                    if ordering[k+1] in c[j]:
                        counter += 1
                        
        if counter < len(c[j]):
            return False
    
    return True
 
sys.stdin = open("lineup.in","r")
sys.stdout = open("lineup.out","w")

n = int(input())

c = dict()
for i in range(n):
    s = input().split()
    if s[0] not in c.keys():
        c[s[0]] = []
    c[s[0]].append(s[5])

cows = ['Bessie','Buttercup','Belinda','Beatrice','Bella','Blue','Betsy','Sue']
cows.sort()
orderings = permutations(cows)

for i in orderings:
    if check_constraints(i):
        for a in range(8):
            print(i[a])
        break

