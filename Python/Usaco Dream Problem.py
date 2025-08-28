n,m = input().split()
n = int(n)
m = int(m)
digits = [0] *n

# % method

#for i in range(n,m):
#    temp = i
#    while temp > 0:
#        index = temp % 10
#        digits[index] += 1
#        temp /= 10
#print(digits)

#string method
for i in range(n,m):
    s = str(i)
    length = len(s)
    for j in range(length):
        c = j
        index = int(c)
        print(index)
        digits[index] += 1
print(digits)