import sys

#sys.stdin = open("tttt.in","r")
#sys.stdout = open("tttt.out","w")

#functions------------------------

def checkOne(arr,cow):
    #check rows and columns
    for loop in range(3):
        if cow == arr[0][loop] and cow == arr[1][loop] and cow == arr[2][loop]:
            return 1
        if cow == arr[loop][0] and cow == arr[loop][1] and cow == arr[loop][2]:
            return 1
    
    if cow == arr[0][0] and cow == arr[1][1] and cow == arr[2][2]:
        return 1
    if cow == arr[0][2] and cow == arr[1][1] and cow == arr[2][0]:
        return 1
    
    return 0

def checkValid(x,y,z,cow1,cow2):
    if x != cow1 and x != cow2:
        return bool(0)
    if y != cow1 and y != cow2:
        return bool(0)
    if z != cow1 and z != cow2:
        return bool(0)
    if x != cow1 and y != cow1 and z != cow1:
        return bool(0)
    if x != cow2 and y != cow2 and z != cow2:
        return bool(0)
    return bool(1)
    
def checkTeam(arr,cow1,cow2):
    if cow1 != cow2:
        for loop in range(3):
            if checkValid(arr[0][loop], arr[1][loop], arr[2][loop], cow1, cow2):
                return 1
            if checkValid(arr[loop][0], arr[loop][1], arr[loop][2], cow1, cow2):
                return 1
        
        if checkValid(arr[0][0], arr[1][1], arr[2][2], cow1, cow2):
            return 1
        if checkValid(arr[0][2], arr[1][1], arr[2][0], cow1, cow2):
            return 1
    
    return 0


    
board = [0] * 3
board[0] = input()
board[1] = input()
board[2] = input()

teams = 0
individuals = 0

alphabet = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']

for i in alphabet:
    individuals += checkOne(board,i)
    
for i in alphabet:
    for j in alphabet:
        teams += checkTeam(board,i,j)
        
print(individuals)
print(int(teams/2))
    




            

