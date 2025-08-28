days=int(input())
tennis=0
golf=0
for i in range(days):
    temp,hum = (input()).split()
    humidity=int(hum)
    temperature=int(temp)
    days=days+1
    if int(temperature)<60:
        if 40<=humidity<60:
            print("Day "+str(days)+": Lucy plays tennis")
    if int(temperature)>=60:
        if 40<=humidity>60:
            print("Day "+str(days)+": Lucy plays golf")
    


#n = int(input())
#counter = 0
#for i in range(1,n):
#    a = (n-((2*i)-1))
#    b = ((2*i)+2*(i-1))
 #   if a % b == 0 and a/b >= i:
  #      counter = counter + 1
   # elif n%(4*i) == 0 and n/(4*i) >= (i+1):
    #    counter =counter + 1
#print(counter)