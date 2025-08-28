def findDis(cow1,cow2,direction):
    loc = 0
    if direction == 'previous':
        counter = -1
        loc = year[cow2] - 1
        while loc % 12 != year[cow1]:
            loc -= 1
            counter -= 1
    
    elif direction == 'next':
        counter = 1
        loc = year[cow2] + 1
        while loc % 12 != year[cow1]:
            loc += 1
            counter += 1

    
    return counter + dis[cow2]
n = int(input())
calender = ['Ox','Tiger','Rabbit','Dragon','Snake','Horse','Goat','Monkey','Rooster','Dog','Pig','Rat']
dis = {'Bessie':0}
year = {'Bessie': 0}

for i in range(n):
    s = input().split()
    year[s[0]] = calender.index(s[4])
    dis[s[0]] = findDis(s[0], s[7], s[3])
        
print(abs(dis['Elsie']))