import sys
sys.stdin = open("circlecross.in","r")
sys.stdout = open("circlecross.out","w")


word = input()
ans = 0
pos = [-1] * 26
for i in range(26):
    pos[i] = [-1] * 2
    for j in range(26):
        pos[i][1] = 0

#determine start/end positons of each letter--------------------------
for i in range(52):
    myChar = word[i]
    charV = ord(myChar.lower()) - 97
    if pos[charV][0] == -1:
        pos[charV][0] = i
    else:
        pos[charV][1] = i
#count letters in the middle-------------------
for i in range(26):
    startP = pos[i][0]; endP = pos[i][1]
    letters = word[startP+1:endP]
    counter = [0] * 26
    for j in range(len(letters)): #fill counter array
        myChar = letters[j]
        charV = ord(myChar.lower()) - 97
        counter[charV] += 1
    #count 1s in counter array
    for j in range(26):
        if counter[j] == 1:
            ans += 1

print(int(ans/2))