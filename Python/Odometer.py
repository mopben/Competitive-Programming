import sys

sys.stdin = open("odometer.in","r")
sys.stdout = open("odometer.out","w")

x,y = map(str,input().split())

ans = 0

for i in range(3,len(y)+1):
    for j in range(0,10):
        number = str(str(j) * i)
        for k in range(i):
            for a in range(10):
                
                temp_number = list(number)
                temp_number[k] = str(a)
                temp_number = "".join(temp_number)
                
                if int(temp_number) >= int(x) and int(temp_number) <= int(y) and temp_number != number and temp_number[0] != '0':
                    ans += 1


print(ans)