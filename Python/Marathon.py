import sys

sys.stdin = open("marathon.in","r")
sys.stdout = open("marathon.out","w")

n = int(input())

x = [0] * n; y = [0] * n

for i in range(n):
    x[i],y[i] = map(int,input().split())
    
total_dis = 0
for i in range(n-1):
    total_dis += abs(x[i] - x[i+1]) + abs(y[i] - y[i+1])

max_dis = 0
for i in range(n-2):
    dis = abs(x[i] - x[i+1]) + abs(y[i] - y[i+1])
    dis_2 = abs(x[i+1] - x[i+2]) + abs(y[i+1] - y[i+2])
    dis_3 = abs(x[i] - x[i+2]) + abs(y[i] - y[i+2])
    
    max_dis = max(max_dis,dis + dis_2 - dis_3)
    
print(total_dis - max_dis)
