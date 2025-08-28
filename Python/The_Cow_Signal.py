import sys

sys.stdin = open("cowsignal.in","r")
sys.stdout = open("cowsignal.out","w")

m,n,k = map(int,input().split())

signal = [0] * m

for y in range(m):
    signal[y] = input()
    for i in range(k):
        for x in range(n):
            print(signal[y][x] * k, end = '')
        print()
