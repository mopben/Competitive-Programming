n = int(input())

cows = [0] * n
for i in range(n):
    cows[i] = int(input())

sortedCows = sorted(cows)
tempCows = cows.copy()
#find bessie
bessie = 0
for i in range(n):
    tempCows = cows.copy()
    k = i
    for j in reversed(range(i+1)):
        tempCows[k], tempCows[j] = tempCows[j], tempCows[k]
        k = j
        if tempCows == sortedCows:
            b= i

while cows != sortedCows:
    for i in range(n):
        tempCows = cows.copy()
        tempCows[b], tempCows[i] = tempCows[i], tempCows[b]
        if tempCows == sortedCows:
            print(swaps)
            break
        
        if b == n-1:
            if tempCows[b] > tempCows[b-1]:
                if i != n-1:
                    if tempCows[i] < tempCows[i+1] and tempCows[i] > tempCows[i-1]:
                        cows = tempCows
                        b = i
                        swaps += 1
                        break
                else:
                    if tempCows[i] < tempCows[i+1]:
                        cows = tempCows
                        b = i
                        swaps += 1
                        break
                
        else:
            if tempCows[b] > tempCows[b-1] and tempCows[b] < tempCows[b+1]:
                if i != n-1:
                    if tempCows[i] < tempCows[i+1] and tempCows[i] > tempCows[i-1]:
                        cows = tempCows
                        b = i
                        swaps += 1
                        break
                else:
                    if tempCows[i] < tempCows[i+1]:
                        cows = tempCows
                        b = i
                        swaps += 1
                        break