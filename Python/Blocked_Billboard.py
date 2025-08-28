import sys

sys.stdin = open("billboard.in","r")
sys.stdout = open("billboard.out","w")
x1,y1,x2,y2 = map(int,input().split())
x3,y3,x4,y4 = map(int,input().split())
x5,y5,x6,y6 = map(int,input().split())

area1 = (x2-x1)*(y2-y1)
area2 = (x4-x3)*(y4-y3)

leftX = max(x1, x5)
rightX = min(x2, x6)
bottomY = max(y1, y5)
topY = min(y2, y6)

if leftX < rightX and bottomY < topY:
    area1 -= max(0,(rightX - leftX)*(topY - bottomY))

leftX = max(x3, x5)
rightX = min(x4, x6)
bottomY = max(y3, y5)
topY = min(y4, y6)
if leftX < rightX and bottomY < topY:
    area2 -= max(0,(rightX - leftX)*(topY - bottomY))


print(area1+area2)