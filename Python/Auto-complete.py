import sys
sys.stdin = open("auto.in","r")
sys.stdout = open("auto.out","w")

w,n = map(int,input().split())

dictionary = []
for i in range(w):
    dictionary.append(input())

for i in range(n):
    index, word = input().split()
    index = int(index) 
    valid = []
    counter = 0
    for j in range(w):
        e = j
