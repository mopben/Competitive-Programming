fin = open("billboard.in","r")
fout = open("billboard.out","w")

x1,y1,x2,y2 = map(int,fin.readline().split())
X1,Y1,X2,Y2 = map(int,fin.readline().split())
#x1,y1,x2,y2 = map(int,input().split())
#X1,Y1,X2,Y2 = map(int,input().split())

area = (abs(x2 - x1)) * (abs(y2 - y1))

if x1 >= X1 and x2 <= X2:
    if Y1 < y1 and Y2 > y2:
        area = 0
    elif y1 <= Y1 <= y2 and Y2 >= y2:
        area -= abs(y2-Y1) * abs(x2-x1)
    elif y1 <= Y2 <= y2 and Y1 <= y1:
        area -= abs(Y2-y1) * abs(x2-x1)
        
elif y1 >= Y1 and y2 <= Y2:
    if X1 < x1 and X2 > x2:
        area = 0
    elif x1 <= X1 <= x2:
        area -= abs(y2-y1) * abs(x2-X1)
    elif x1 <= X2 <= x2:
        area -= abs(y2-y1) * abs(X2-x1)

#print(area)
fout.write(str(area))
fout.close()