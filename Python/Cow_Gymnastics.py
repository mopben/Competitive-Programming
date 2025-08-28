
fin = open ("gymnastics.in", "r")
fout = open ("gymnastics.out", "w")

k,n = map(int, fin.readline().split())
#k,n = input().split()
#k = int(k); n = int(n)
pairs = 0
pos = [0] * k
ranking = [0] * k
for i in range(k):
    ranking[i] = [0] * n
    pos[i] = [0] * n
    
for i in range(k):
    temp = fin.readline().split()
    #temp = input().split()
    for j in range(n):
        ranking[i][j] = int(temp[j]) - 1

for i in range(k):
    for j in range(n):
        pos[i][ranking[i][j]] = j

for i in range(n):
    for a in range(n):
        lesscounter = 0
        greatcounter = 0
        for b in range(k):
            if pos[b][i] < pos[b][a]:
                lesscounter += 1
            if pos[b][i] > pos[b][a]:
                greatcounter += 1
                        
        if lesscounter == k or greatcounter == k:
            pairs += 1
#print(str(int(pairs/2)))
fout.write(str(int(pairs/2)))
fin.close()
fout.close()