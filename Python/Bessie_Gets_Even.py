import sys

sys.stdin = open("geteven.in","r")
sys.stdout = open("geteven.out","w")

n = int(input())
evenOdd = dict(); 
for i in range(n):
    s = input().split()
    s[1] = int(s[1])
    if s[0] not in evenOdd.keys():
        evenOdd.update({s[0]:[0,0]})
    
    evenOdd[s[0]][s[1]%2] += 1

counter = 0
for b in range(0,2):
    for e in range(0,2):
        for s in range(0,2):
            for i in range(0,2):
                for g in range(0,2):
                    for o in range(0,2):
                        for m in range(0,2):
                            if ((b+e+s+s+i+e)*(g+o+e+s)*(m+o+o)) % 2 == 0:
                                counter += evenOdd['B'][b] * evenOdd['E'][e] * evenOdd['S'][s] * evenOdd['I'][i] * evenOdd['G'][g] * evenOdd['O'][o] * evenOdd['M'][m]

print(counter)
