import sys
 
sys.stdin = open("promote.in","r")
sys.stdout = open("promote.out","w")
b1, b2 = map(int,input().split())
s1, s2 = map(int,input().split())
g1, g2 = map(int,input().split())
p1, p2 = map(int, input().split())

bs = 0
sg = 0
gp = 0

gp = p2 - p1
sg = g2 - g1 + gp
bs = s2 - s1 + sg

print(bs)
print(sg)
print(gp)