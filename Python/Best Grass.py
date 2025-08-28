#setup --------------------------------

r,c = input().split()
r = int(r)
c = int(c)
counter = 0
array = [''] * r
field = [''] * r

#generate array ----------------------

for i in range(r):
    array[i] = input()
    for j in range(c):
        field[i] = array[i]
        
#check grass --------------------------

for i in range(r):
   for j in range(c):
        if field[i][j] == '#':
            if j - 1 == -1:
                counter += 1
            elif field[i][j-1] == '#':
                pass
            elif i - 1 == -1:
                counter += 1
            elif field[i-1][j] == '#':
                pass
            else:
                counter += 1
print(counter)
                
            
