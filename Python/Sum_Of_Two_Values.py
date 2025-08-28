import sys

n,x = map(int,input().split())

arr = [int(x) for x in input().split()]

value_needed = dict()

for i,val in enumerate(arr):
    if x - val in value_needed:
        print(i+1,value_needed[x-val])
        sys.exit()
    value_needed[val] = i + 1

print("IMPOSSIBLE")