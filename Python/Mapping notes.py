#map

n = int(input())
arr = [0] * n
for i in range(n):
    num = int(input())
    arr[num] += 1
for i in range (n):
    while arr[i] > 0:
        print(i)
        arr[i] -= 1