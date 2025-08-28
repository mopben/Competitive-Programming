fin = open("sleepy.in","r")
fout = open("sleepy.out","w")
#n = int(input())
#cows = input().split()
n = int(fin.readline())
cows = fin.readline().split()
for i in range(n):
    cows[i] = int(cows[i])

sorts = n-1

for i in range(n-2,-1,-1):

    if cows[i] < cows[i+1]:
        sorts = i
    else:
        break

#print(sorts)
fout.write(str(sorts))
fout.close()