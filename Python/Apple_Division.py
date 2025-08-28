def solve(i,s1,s2):
    if i == n:
        return abs(s2 - s1)
    
    return min(solve(i+1,s1+w[i],s2),solve(i+1,s1,s2+w[i]))

n = int(input())
w = [int(x) for x in input().split()]

print(solve(0,0,0))