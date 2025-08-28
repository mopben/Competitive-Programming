import math
import sys

def solve(a,b,c):
    dis = (b * b) - (4 * a * c)
    sqrt_val = math.sqrt(abs(dis))
    
    return (-b + sqrt_val)/(2 * a), (-b - sqrt_val)/(2 * a)

sys.stdin = open("whatbase.in","r")
sys.stdout = open("whatbase.out","w")

k = int(input())

for i in range(k):
    s,s1 = input().split()
    
    x = list(s); y = list(s1)
    x[0] = int(x[0]); x[1] = int(x[1]); x[2] = int(x[2])
    y[0] = int(y[0]); y[1] = int(y[1]); y[2] = int(y[2])
    
    for a in range(10,15001):
        equation = (x[0]*(a**2))+(x[1]*a)+(x[2])
        
        sol1,sol2 = solve(y[0],y[1],y[2] - equation)
        temp_sol1 = int(sol1); temp_sol2 = int(sol2)
        
        if temp_sol1 == sol1 and temp_sol1 >= 10:
            print(a,temp_sol1)
            break
        
        elif temp_sol2 == sol2 and temp_sol2 >= 10:
            print(a,temp_sol2)
            break

        