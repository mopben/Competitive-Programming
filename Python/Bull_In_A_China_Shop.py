import sys
import time

start = time.time()

#sys.stdin = open("bcs.in","r")
#sys.stdout = open("bcs.out","w")

def get(piece, x, y): #2d array pieces, ints x and y
    return x >= 0 and x < len(piece) and y >= 0 and y < len(piece[x]) and piece[x][y]

n,k = map(int,input().split())
original = [0] * n

for i in range(n):
    s = input()
    original[i] = [0] * n
    for j in range(n):
        original[i][j] = s[j] == '#'

pieces = [0] * k
for i in range(k):

    
    pieces[i] = [0] * n
    for j in range(n):
        pieces[i][j] = [0] * n
        s = input()
        for a in range(n):
            pieces[i][j][a] = s[a] == '#'


for i in range(k):
    for j in range(i+1,k):
        for idx in range(-n+1,n):
            for idy in range(-n+1,n):
                for jdx in range(-n+1,n):
                    for jdy in range(-n+1,n):
                        good = True
                        x = 0
                        while x<n and good:
                            y = 0
                            while y<n and good:
                                iLoc = get(pieces[i],idx+x,idy+y)
                                jLoc = get(pieces[j],jdx+x,jdy+y)
                                if iLoc and jLoc:
                                    good = False

                                if original[x][y] != (iLoc or jLoc):

                                    good = False

                                y+=1
                            x+=1
                        if good:
                            print(i+1,j+1)
                            end = time.time()
                            print(end-start)

                            sys.exit()


        