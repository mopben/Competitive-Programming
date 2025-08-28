import sys
sys.stdin = open("hps.in","r")
sys.stdout = open("hps.out","w")

n = int(input())

counter1 = 0; counter2 = 0; counter3 = 0; counter4 = 0; counter5 = 0; counter6 = 0
for i in range(n):
    c1,c2 = map(int,input().split())
    
    #1 is rock and 2 is paper and 3 is scissor
    if (c1 == 1 and c2 == 3) or (c1 == 2 and c2 == 1) or (c1 == 3 and c2 == 2):
        counter1 += 1

    #1 is rock and 2 is scissor and 3 is paper
    if (c1 == 1 and c2 == 2) or (c1 == 2 and c2 == 3) or (c1 == 3 and c2 == 1):
        counter2 += 1
    
    #1 is paper and 2 is rock and 3 is scissor
    if (c1 == 1 and c2 == 2) or (c1 == 2 and c2 == 3) or (c1 == 3 and c2 == 1):
        counter3 += 1
    
    #1 is paper and 2 is scissor and 3 is rock
    if (c1 == 1 and c2 == 3) or (c1 == 2 and c2 == 1) or (c1 == 3 and c2 == 2):
        counter4 += 1
    
    #1 is scissor and 2 is rock and 3 is paper
    if (c1 == 1 and c2 == 3) or (c1 == 2 and c2 == 1) or (c1 == 3 and c2 == 2):
        counter5 += 1
    
    #1 is scissor and 2 is paper and 3 is rock
    if (c1 == 1 and c2 == 2) or (c1 == 2 and c2 == 3) or (c1 == 3 and c2 == 1):
        counter6 += 1

print(max(counter1,counter2,counter3,counter4,counter5,counter6))