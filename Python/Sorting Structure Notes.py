def comp (c):
    return c[1] #it will sort by the second item.

n = int(input()) #n cities
cityArr = n*[0] #create your array
for i in range (n): #get inputs
    name=input()
    population = int(input())
    cityArr[i] = name,population
print(cityArr)
cityArr.sort(key = comp) #Sort it by population

#print the result   
for i in range(n):
    print(str(i) + ": " + cityArr[i][0] + ", " + str(cityArr[i][1]))
