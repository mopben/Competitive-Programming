n = int(input())
flowers = input().split()
counter = 0
for i in range(n):
    flowers[i] = float(flowers[i])
    
for i in range(n):
    for j in range(i,n):
        tempFlowers = [0] * n
        average = 0
        dividedBy = 0
        for a in range(i,j+1):
            average += flowers[a]
            dividedBy += 1
        for a in range(i,j+1):
            tempFlowers[a] = flowers[a]
        average = float(average/dividedBy)
        if average in tempFlowers:
            counter += 1

print(counter)
