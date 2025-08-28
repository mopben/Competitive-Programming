fin = open("shell.in","r")
fout = open("shell.out","w")

n = int(fin.readline())
#n = int(input())
counter = 0
maxCounter = 0
structure = [0] * n
for i in range(n):
    structure[i] = [0] * 3
    #A,B,G = input().split()
    A,B,G = fin.readline().split()
    structure[i][0] = int(A); structure[i][1] = int(B); structure[i][2] = int(G)


for i in range(3):
    pebble = i+1
    location = [1,2,3]
    counter = 0
    for j in range(n):
        a = structure[j][0]; b = structure[j][1]; g = structure[j][2]
        if a == pebble:
            pebble = b
        elif b == pebble:
            pebble = a
        if g == pebble:
            counter += 1
    if counter > maxCounter:
        maxCounter = counter
        
#print(maxCounter)
fout.write(str(maxCounter))
fout.close()