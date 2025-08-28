"""
ID: benqia51
LANG: PYTHON3
TASK: friday
"""
daysOfWeek = [0] * n

n = int(input())
leap = bool(0)


for i in range(1900,1900+n-1):
    #determine if leap year------------------------
    if i % 4 == 0 and str(i[2:4]) != '00':
        leap = bool(1)
    
    elif str(i[2:4]) == '00' and i % 400 == 0:
        leap = bool(1)
        
    #calculate days in the month----------------------
    for j in range(12):
        if j == 4 or j == 6 or j == 9 or j == 11:
            days = 30
        elif j == 2:
            if leap:
                days = 29
            else:
                days = 28
        else:
            days = 31
    
    #calculate how many 13th's----------------------
        
    
    leap = bool(0)
        
        