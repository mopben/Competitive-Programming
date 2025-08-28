x1,y1,x2,y2 = map(int,input().split())
x3,y3,x4,y4 = map(int,input().split())
x5,y5,x6,y6 = map(int,input().split())

area = (x2-x1)*(y2-y1)

leftX = max(x1, x3)
rightX = min(x2, x4)
bottomY = max(y1, y3)
topY = min(y2, y4)

area -= abs(rightX - leftX)*abs(topY - bottomY)

leftX2 = max(x1, x5)
rightX2 = min(x2, x6)
bottomY2 = max(y1, y5)
topY2 = min(y2, y6)

area -= abs(rightX2 - leftX2)*abs(topY2 - bottomY2)

leftX3 = max(leftX,leftX2)
rightX3 = min(rightX,rightX2)
bottomY3 = max(bottomY,bottomY2)
topY3 = min(topY,topY2)

area += abs(rightX3 - leftX3)*(topY - bottomY3)


if area == 0:
    print("NO")
else:
    print("YES")