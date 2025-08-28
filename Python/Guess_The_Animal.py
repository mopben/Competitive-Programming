#a simplified version of the official solution that uses dictionaries
import sys
sys.stdin = open("guess.in","r")
sys.stdout = open("guess.out","w")

n = int(input())

char = dict()
for i in range(n):
    s = input().split()
    char.update({s[0]:set()})
    for j in range(int(s[1])):
        char[s[0]].add(s[j+2])

max_intersection = 0
for i in char.keys():
    for j in char.keys():
        if i != j:
            max_intersection = max(len(char[i].intersection(char[j])),max_intersection)

print(max_intersection+1)