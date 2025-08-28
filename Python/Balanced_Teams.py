import sys
from itertools import combinations
sys.stdin = open("bteams.in","r")
sys.stdout = open("bteams.out","w")

skills = []
for i in range(12):
    skills.append(int(input()))

comb = list(combinations(skills,3))

ans = 999999999999999
all_sum = sum(skills)
for team1 in comb:
    temp_skills = skills.copy()
    
    for i in team1:
        temp_skills.remove(i)
    
    comb_2 = list(combinations(temp_skills,3))
    for team2 in comb_2:
    
        temp_temp_skills = temp_skills.copy()
        for i in team2:
            temp_temp_skills.remove(i)
        
        comb_3 = list(combinations(temp_temp_skills,3))
        
        for team3 in comb_3:
            sum_t1 = sum(team1); sum_t2 = sum(team2); sum_t3 = sum(team3)
            sum_t4 = all_sum - sum_t1 - sum_t2 - sum_t3
           
            ans = min(ans,max(sum_t1,sum_t2,sum_t3,sum_t4) - min(sum_t1,sum_t2,sum_t3,sum_t4))

print(ans)