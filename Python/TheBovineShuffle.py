fin = open("shuffle.in","r")
fout = open("shuffle.out","w")

#n = int(input())
n = int(fin.readline())


#shuffle = input().split()
shuffle = fin.readline().split()

for i in range(n):
    shuffle[i] = int(shuffle[i])
    shuffle[i] -= 1

#cowID = input().split()
cowID = fin.readline().split()
temp = [0] * n

#loop-----------------------------------------------------------------------------

for i in range(3):
    for j in range(n):
        temp[j] = cowID[shuffle[j]]
    for j in range(n):
        cowID[j] = temp[j]
    
for i in range(n):
    #print(cowID[i])
    fout.write(cowID[i])
    fout.write("\n")
fout.close()