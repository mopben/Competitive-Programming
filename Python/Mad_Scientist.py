fin = open("breedflip.in","r")
fout = open("breedflip.out","w")

#n = int(input())
#a = input()
#b = input()
n = int(fin.readline())
a = fin.readline()
b = fin.readline()

counter = 0
flips = 0
for i in range(n):
    if a[i] != b[i]:
        counter += 1
    else:
        if counter >= 1:
            flips += 1
        counter = 0
#print(flips)
fout.write(str(flips))
fout.close()