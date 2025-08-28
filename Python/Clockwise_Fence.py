n = int(input())

for i in range(n):
    fence = input()
    pasture = [0] * 20
    prev = fence[0]
    right = 0; left = 0
    for j in range(len(fence)):
        if prev == 'N':
            if fence[j] == 'W':
                left += 1
            elif fence[j] == 'E':
                right += 1
                
        elif prev == 'S':
            if fence[j] == 'W':
                right += 1
            elif fence[j] == 'E':
                left += 1
                
        elif prev == 'W':
            if fence[j] == 'N':
                right += 1
            elif fence[j] == 'S':
                left += 1
        
        elif prev == 'E':
            if fence[j] == 'N':
                left += 1
            elif fence[j] == 'S':
                right += 1
                
        prev = fence[j]

    if right > left:
        print("CW")
    else:
        print("CCW")


                    


