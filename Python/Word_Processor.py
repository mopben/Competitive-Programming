
#this is really bad and is really complicated and doesn't even work go to new one





#fin = open("word.in", "r")
#fout = open("word.out","w")

n,k = input().split()
#n,k = fin.readline().split()
n = int(n); k = int(k)
characters = -1
essay = [0] * n

for i in range(n):
    essay[i] = [0] * (k+1)

column = 0
words = input().split()
#words = fin.readline().split()
characters = 0
#create formatting----------------------------------------------------------------------------
for i in range(n):
    tempCharacters = characters
    tempCharacters += len(words[i])

#same line----------------------------------------------------------
    if tempCharacters <= k:
        word = words[i]
        for j in range(characters+1,k+1):
            if j-1 < len(word) + characters:
                if essay[column][j] == 0:
                    essay[column][j]= word[j-1-characters]
            else:
                break
        characters += len(words[i])
      
#new line-----------------------------------------------------------------
    else:

        column += 1
        characters = 0
        word = words[i]
        for j in range(len(word)):
            essay[column][j] = word[j]
        previousWord = len(word)
        characters += len(words[i])

#create final draft------------------------------------------------------
finalEssay = [0] * n

for i in range(n):
    s = []
    counter = 0
    for j in range(k+1):
        if essay[i][j] != 0:
            s.append(essay[i][j])
        else:
            counter += 1
    if counter == k+1:
        s.clear()
    finalEssay[i] = "".join(s)

#print------------------------------------------------------

print(finalEssay)
for i in range(n):
    if not finalEssay[i]:
        pass
    else:

        for j in range(n):
            if words[j] in finalEssay[i]:
                print('words-',words[j])
                print('finalEssay[i]-',finalEssay[i])
            