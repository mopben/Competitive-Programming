import sys

sys.stdin = open("lazy.in","r")
sys.stdout = open("lazy.out","w")

n,k = map(int,input().split())

grass = []

for i in range(n):
    grass.append(input().split())
    grass[i][0] = int(grass[i][0]); grass[i][1] = int(grass[i][1])


field = [0] * 1000003

for i in range(n):
    field[grass[i][1]] = grass[i][0]

x = 0
y = min(len(field)-2,k+k)

counter = 0
for i in range(x,y):
    counter += field[i]

max_counter = counter
for i in range(max(len(field)-max(x,y)-k,1)):
    x += 1; y += 1
    counter -= field[x-1]
    counter += field[y]
    #print(x,y)
    #print('counter',counter)
    max_counter = max(counter,max_counter)

print(max_counter)
                