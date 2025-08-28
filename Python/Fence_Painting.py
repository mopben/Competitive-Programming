fin = open("paint.in","r")
fout = open("paint.out","w")

#a,b = map(int,input().split())
#c,d = map(int,input().split())
a,b = map(int,fin.readline().split())
c,d = map(int,fin.readline().split())
counter = (b-a)+(d-c)
counter -= max(min(b,d)-max(a,c),0)

#print(counter)
fout.write(str(counter))