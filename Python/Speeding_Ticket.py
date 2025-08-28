fin = open("speeding.in","r")
fout = open("speeding.out","w")
#inputs-----------------------------------
#n,m = map(int,input().split())
n,m = map(int,fin.readline().split())

road = [0] * n
journey = [0] * m
for i in range(n):
    #road[i] = input().split()
    road[i] = fin.readline().split()
    
    road[i][0] = int(road[i][0]); road[i][1] = int(road[i][1])
for i in range(m):
    #journey[i] = input().split()
    journey[i] = fin.readline().split()
    
    journey[i][0] = int(journey[i][0]); journey[i][1] = int(journey[i][1])
  
#simulate-------------------------------------
maxCounter = 0
distance = 0
roadSeg = 0
for i in range(m):
    counter = 0
    while True:
        counter = journey[i][1] - road[roadSeg][1]
        if counter > maxCounter:
            maxCounter = counter
            
        if journey[i][0] > road[roadSeg][0]:
            journey[i][0] -= road[roadSeg][0]
            road[roadSeg][0] = 0
            roadSeg += 1
        
        elif journey[i][0] < road[roadSeg][0]:
            road[roadSeg][0] -= journey[i][0]
            journey[i][0] = 0
            break
    
        elif journey[i][0] == road[roadSeg][0]:
            journey[i][0] = 0
            road[roadSeg][0] = 0
            roadSeg += 1
            break
    
       
#print(maxCounter)
fout.write(str(maxCounter))
fout.close()
