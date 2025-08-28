def find_permutations(ans,s):
    if len(ans) == n:
        if ans not in used:
            ANS.append(ans)
            used.add(ans)
        return 0
    
    for i in range(len(s)):
        temp_s = s.copy()
        temp_s.pop(i)
        find_permutations(ans + s[i],temp_s)
        
    return 0
    
temp = input()
n = len(temp)

string = [0] * n
for i in range(n):
    string[i] = temp[i]
    
string.sort()
ANS = []; used = set()
find_permutations('',string)


print(len(ANS))
for i in range(len(ANS)):
    print(ANS[i])