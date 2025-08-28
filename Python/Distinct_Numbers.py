n = int(input())
arr = [int(x) for x in input().split()]

temp = set()

for i in range(n):
    temp.add(arr[i])
    
print(len(temp))