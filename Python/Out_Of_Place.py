fin = open("outofplace.in","r")
fout = open("outofplace.out","w")

n = int(fin.readline())
#n = int(input())


counter =0
lineup = [0] * n
sortedLineup = [0] * n
for i in range(n):
    #sortedLineup[i] = int(input())
    sortedLineup[i] = int(fin.readline())
    lineup[i] = sortedLineup[i]

sortedLineup.sort()

for i in range(n):
    if sortedLineup[i] != lineup[i]:
        counter += 1

counter -= 1
fout.write(str(counter))
fout.close()
#print(counter)