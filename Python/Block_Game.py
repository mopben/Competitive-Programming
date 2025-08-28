fin = open("blocks.in","r")
fout = open("blocks.out","w")
#n = int(input())
n = int(fin.readline())

blocks = [0] * n
for i in range(n):
    #blocks[i] = input().split()
    blocks[i] = fin.readline().split()

alphabet = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
alphabetCounter = [0] * 26

for i in range(26):
    for j in range(n):
        alphabetCounter[i] += max(blocks[j][0].count(alphabet[i]), blocks[j][1].count(alphabet[i]))

for i in range(26):
    #print(alphabetCounter[i])
    fout.write(str(alphabetCounter[i]))
    fout.write("\n")
fout.close()
        
                    
        