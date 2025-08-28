fin = open("word.in", "r")
fout = open("word.out","w")

#n,k = input().split()
n,k = fin.readline().split()
n = int(n); k = int(k)
characters = -1
essay = [0] * n

for i in range(n):
    essay[i] = [0] * (k+1)

#words = input().split()
words = fin.readline().split()
characters = 0
#create formatting----------------------------------------------------------------------------
for i in range(n):
    tempCharacters = characters
    tempCharacters += len(words[i])

#same line----------------------------------------------------------
    if tempCharacters <= k:
        #print(words[i],end = '')
        fout.write(words[i])
        characters += len(words[i])
        if i+1 < n:
            tempCharacters += len(words[i+1])
            if tempCharacters <= k:
                fout.write(' ')
                #print(' ', end = '')
      
#new line-----------------------------------------------------------------
    else:
        fout.write("\n")
        fout.write(words[i])
        #print()
        #print(words[i],end = '')
        characters = 0
        characters += len(words[i])
        tempCharacters = characters

        if i+1 < n:
            tempCharacters += len(words[i+1])
            if tempCharacters <= k:
                #print(' ',end = '')
                fout.write(' ')
        


fout.close()