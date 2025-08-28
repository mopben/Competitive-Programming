fin = open("mixmilk.in","r")
fout = open("mixmilk.out","w")

capacity1, amount1 = fin.readline().split()
capacity2, amount2 = fin.readline().split()
capacity3, amount3 = fin.readline().split()

#capacity1, amount1 = input().split()
#capacity2, amount2 = input().split()
#capacity3, amount3 = input().split()

capacity1 = int(capacity1); capacity2 = int(capacity2); capacity3 = int(capacity3)
amount1 = int(amount1); amount2 = int(amount2); amount3 = int(amount3)

for i in range(33):
    amount = min(amount1, capacity2-amount2)
    amount1 -= amount
    amount2 += amount
    amount = min(amount2, capacity3-amount3)
    amount2 -= amount
    amount3 += amount
    amount = min(amount3, capacity1-amount1)
    amount3 -= amount
    amount1 += amount
    
amount = min(amount1, capacity2-amount2)
amount1 -= amount
amount2 += amount


#print(amount1)
#print(amount2)
#print(amount3)
fout.write(str(amount1))
fout.write("\n")
fout.write(str(amount2))
fout.write("\n")
fout.write(str(amount3))

fout.close()

