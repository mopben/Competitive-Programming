def find_close():
    low = 9999999
    index = 0
    counter = 0
    for ind in range(n):
        temp = (h+1) - c[ind]
        
        if temp > 0:
            if temp < low:
                low = temp
                index = ind
            counter += 1
    
    counter = h+1 - counter
    return low,index,counter

n,l = map(int,input().split())
c = [int(x) for x in input().split()]

h = 0
for i in reversed(range(n)):
    counter = 0
    for j in range(n):
        if c[j] >= i:
            counter += 1

    if counter >= i:
        h = i
        break

while l > 0:
    dis,close,amount = find_close()
    c[close] += dis
    l -= dis
    if amount == 1 and l >= 0:
        h += 1
    
print(min(h,n))