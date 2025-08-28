import sys
sys.stdin = open("swap.in","r")
sys.stdout= open("swap.out","w")

def swap(arr,x,y):
    tempArr = arr[x:(y+1)]
    tempArr.reverse()
    arr[x:(y+1)] = tempArr
    
    
def swapA(arr):
    swap(arr,a1,a2)
    return arr
def swapB(arr):
    swap(arr,b1,b2)
    return arr

n,k = map(int,input().split())
a1,a2 = map(int,input().split())
b1,b2 = map(int,input().split())

a1 -= 1; a2 -= 1; b1 -= 1; b2 -= 1

cows = [0] * n

for i in range(n):
    cows[i] = i+1

for i in range(k):
    cows = swapA(cows)
    cows = swapB(cows)

for i in range(n):
    print(cows[i])
    