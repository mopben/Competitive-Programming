#setup
cowsIndex = 0
n,l = input().split()
n = int(n)
l = int(l)

cows = [] * n
elimSeq = []*n


for i in range(1,n+1):
    cows.append(i)

elimSeq.append(input().split())

#main loop

j = 0
first = True
while j < n:
    if first == True:
        first = False
        counter = elimSeq[0][j]
        counter = int(counter)
        n = len(cows)
        
    else:
        j += 1
        if j >= l:
            j = 0
        counter = elimSeq[0][j]
        counter = int(counter)
        n = len(cows)  #you have cow numbers in cows list

#calculate cow index

    for a in range(counter-1): #count this many times
        if cowsIndex == len(cows):
            cowsIndex = 0
        cowsIndex = (cowsIndex+1) % n
    cows.pop(cowsIndex)#eliminate cow

print(cows)