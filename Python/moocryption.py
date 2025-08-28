import copy
import sys

sys.stdin = open("moocrypt.in","r")
sys.stdout = open("moocrypt.out","w")

def count():
    moos = 0
    
    if y < n - 2:
        if puzzle[y+1][x] == o and puzzle[y+2][x] == o:
            moos += 1
                
    if x < k - 2:
        if puzzle[y][x+1] == o and puzzle[y][x+2] == o:
            moos += 1
    
    if y > 1:
        if puzzle[y-1][x] == o and puzzle[y-2][x] == o:
            moos += 1
    
    if x > 1:
        if puzzle[y][x-1] == o and puzzle[y][x-2] == o:
            moos += 1
    
    if y < n - 2 and x < k - 2:
        if puzzle[y+1][x+1] == o and puzzle[y+2][x+2] == o:
            moos += 1
    
    if y < n - 2 and x > 1:
        if puzzle[y+1][x-1] == o and puzzle[y+2][x-2] == o:
            moos += 1
    
    if y > 1 and x < k - 2:
        if puzzle[y-1][x+1] == o and puzzle[y-2][x+2] == o:
            moos += 1
    
    if y > 1 and x > 1:
        if puzzle[y-1][x-1] == o and puzzle[y-2][x-2] == o:
            moos += 1
    
    return moos

n,k = map(int,input().split())
puzzle = [0] * n

letters = set()
for i in range(n):
    s = input()
    puzzle[i] = [0] * k
    for j in range(k):
        puzzle[i][j] = s[j]
        letters.add(puzzle[i][j])
        
max_counter = 0
for m in letters: #replaces M
    for o in letters: #replaces O
        if m != o and m != 'M' and o != 'O':
            
            mark = [False] * n
            for i in range(n):
                mark[i] = [False] * k

            counter = 0
            for y in range(n):
                for x in range(k):
                    if puzzle[y][x] == m:
                        counter += count()
            
            max_counter = max(max_counter,counter)

print(max_counter)            