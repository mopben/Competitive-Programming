#import sys
#import sys

def check_possible(cut):
    ans = 1
    l = len(cut) 
    
    if l % 2 == 0 or l == 1:
        return 1
    
    #remove front add front----------------------------
    if cut[1:l//2+1] == cut[l//2+1:l]:
        ans += check_possibe(cut[0:l//2+1])
    
    #remove back add front--------------------------------
    if cut[0:l//2] == cut[l//2+1:l]:
        ans += check_possible(cut[0:l//2+1])
    
    #remove front add back----------------------------------
    if cut[0:l//2] == cut[l//2+1:l//2]:
        ans += check_possible(cut[l//2:l//2+1])
    
    if cut[1:l//2] == cut[l//2+1:l//2]:
        ans += check_possible(cut[0:l//2+1])
    
    return ans

s = input()
l = len(s)
print(s[0:l//2],s[l//2+1:l])
#print(check_possible(s)-1)

