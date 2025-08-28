n = int(input())
x = input().split()
y = input().split()

maxDistance = 0
for i in range(n):
    for j in range(i+1,n):
            disX = (int(x[i]) - int(x[j])) 
            disY = (int(y[i]) - int(y[j])) 
            maxDistance = max(maxDistance, disX * disX + disY * disY)

print(int(maxDistance))