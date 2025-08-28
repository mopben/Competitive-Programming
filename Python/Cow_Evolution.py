#the tree is not proper if there are 2 cows that have the same characteristics, and one of them
#shares a trait with another cow who doesn't share a trait with both of the other cows

import sys
sys.stdin = open("evolution.in","r")
sys.stdout = open("evolution.out","w")
n = int(input())

char = [0] * n

#take inputs
for i in range(n):
    s = input().split()
    char[i] = [0] * int(s[0])
    for j in range(int(s[0])):
        char[i][j] = s[j+1]
    char[i] = set(char[i])


for i in range(n):
    for j in range(n):
        for a in range(n):
            if i != j and i != a and j != a:

                if char[i].intersection(char[j]):
                    if char[i].intersection(char[a]) or char[j].intersection(char[a]):
                        if not char[i].intersection(char[j],char[a]):
                            print("no")
                            sys.exit()
                            
                elif char[i].intersection(char[a]):
                    if char[i].intersection(char[j]) or char[j].intersection(char[a]):
                        if not char[i].intersection(char[j],char[a]):
                            print("no")
                            sys.exit()
                
                elif char[j].intersection(char[a]):
                    if char[i].intersection(char[j]) or char[i].intersection(char[a]):
                        if not char[i].intersection(char[j],char[a]):
                            print("no")
                            sys.exit()

print("yes")