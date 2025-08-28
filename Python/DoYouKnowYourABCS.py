#doesn't pass test case 3

integers = input().split()
SortedIntegers = [0] * 7
for i in range(7):
    integers[i] = int(integers[i])
    SortedIntegers[i] = int(integers[i])

SortedIntegers.sort()

switchA = bool(1)
switchB = bool(0)
switchC = bool(0)
Btime = bool(0)
Ctime = bool(0)
for i in range(4):
    if switchB:
        Btime = bool(1)
    if switchC:
        Ctime = bool(1)
    counter = 0
    for j in range(4):
        if SortedIntegers[i] + SortedIntegers[j] in integers:
            counter += 1
            
    if counter >= 2 and switchA:
        A = SortedIntegers[i]
        switchB = bool(1)
        switchA = bool(0)
        
    if counter >= 2 and Btime:
        B = SortedIntegers[i]
        switchC = bool(1)
        switchB = bool(0)
        Btime = bool(0)
        
    if counter >= 2 and Ctime:
        C = SortedIntegers[i]
        break

print(A,B,C)
        
        
        