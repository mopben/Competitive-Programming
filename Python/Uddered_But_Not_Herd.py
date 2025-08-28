
alphabet = input()
string = input()

counter = 0

for i in range(len(string)-1):
    if alphabet.index(string[i]) < alphabet.index(string[i+1]):
        pass
    else:
        counter += 1
counter += 1
print(counter)
    