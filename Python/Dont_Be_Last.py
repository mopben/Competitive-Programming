fin = open('notlast.in','r')
fout = open('notlast.out','w')

#n = int(input())
n = int(fin.readline())
milk = [0] * n
annabelle = 0
bessie = 0
daisy = 0
elsie = 0
gertie = 0
maggie = 0
henrietta = 0

#find total milk produced by each cow-----------------

for i in range(n):
    milk[i] = [0] * 2
    #name, produced = input().split()
    name, produced = fin.readline().split()
    produced = int(produced)
    if name == 'Annabelle':
        annabelle += produced
    if name == 'Bessie':
        bessie += produced
    if name == 'Daisy':
        daisy += produced
    if name == 'Elsie':
        elsie += produced
    if name == 'Gertie':
        gertie += produced
    if name == 'Maggie':
        maggie += produced
    if name == 'Henrietta':
        henrietta += produced

#make milk array----------------------------------------
milk = []
milk.append(annabelle)
milk.append(bessie)
milk.append(daisy)
milk.append(elsie)
milk.append(gertie)
milk.append(maggie)
milk.append(henrietta)
#find and delete lowest milk producer(s)----------------------------------
counter = 0
lowest = min(milk)
for i in range(7):
    if milk[i] == lowest:
        milk[i] = 9999999999999999999999999999999
        counter += 1
if counter == 7:
    #print('Tie')
    fout.write(str('Tie'))
        
secondLowest = min(milk)
#find second lowest milk producer(s)----
for i in range(len(milk)):
    if milk[i] == secondLowest:
        milk[i] = 'ans'

#check if tie and print-----------------------
counter = 0
for i in range(len(milk)):
    if milk[i] == 'ans':
        counter += 1

if counter > 1:
    #print('Tie')
    fout.write('Tie')
else:
    position = milk.index('ans')
    if position == 0:
        #print('Annabelle')
        fout.write(str('Annabelle'))
    if position == 1:
        #print('Bessie')
        fout.write(str('Bessie'))
    if position == 2:
        #print('Daisy')
        fout.write(str('Daisy'))
    if position == 3:
        #print('Elsie')
        fout.write(str('Elsie'))
    if position == 4:
        #print('Gertie')
        fout.write(str('Gertie'))
    if position == 5:
        #print('Maggie')
        fout.write(str('Maggie'))
    if position == 6:
        #print('Henrietta')
        fout.write(str('Henrietta'))
fout.close()
