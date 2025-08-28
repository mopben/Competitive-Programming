import sys

sys.stdin = open("angry.in","r")
sys.stdout = open("angry.out","w")


def explode(arr,radius,bale,direction):
    radius += 1
    while bale > 0 and bale < len(arr) - 1:
        if direction == 'left':
            nextBale = bale
            while nextBale - 1 >= 0 and nextBale - 1 < len(arr) and abs(arr[nextBale - 1] - arr[bale]) <= radius:
                nextBale -= 1
                
            if nextBale == bale:
                break
            
            bale = nextBale
            radius += 1
            
        if direction == 'right':
            nextBale = bale
            while nextBale + 1 >= 0 and nextBale + 1 < len(arr) and abs(arr[nextBale + 1] - arr[bale]) <= radius:
                nextBale += 1
                
            if nextBale == bale:
                break

            bale = nextBale
            radius += 1
    
    return bale
            
n = int(input())

hay = [0] * n

for i in range(n):
    hay[i] = int(input())
    
hay.sort()

ans = 0
index = 0
for i in range(n):
    left = explode(hay, 0, i, 'left')
    right = explode(hay, 0, i, 'right')
    ans =  max(ans, right - left + 1) 

print(ans)