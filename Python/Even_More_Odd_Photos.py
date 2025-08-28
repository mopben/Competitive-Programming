           
n = int(input())
cows = [int(x) for x in input().split()]

even = 0
odd = 0
for i in cows:
    if i % 2 == 0:
        even += 1
    else:
        odd += 1

groups = 0

for i in range(n):
    if i % 2 == 0:
        if even > 0:
            even -= 1
            groups += 1
        elif odd > 1:
            odd -= 2
            groups += 1
        elif odd == 1:
            groups -= 1
            break
    else:
        if odd > 0:
            odd -= 1
            groups += 1
        else:
            break
print(groups)
        