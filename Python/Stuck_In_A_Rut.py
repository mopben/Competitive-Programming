
def checkStopped(c1,c2):
    if c[c1][0] == 'N':
            
        if c[c2][0] == 'E' and c[c1][1] - c[c2][1] < c[c2][2] - c[c1][2] and c[c1][1] > c[c2][1] and stopped[c2] > c[c1][1] - c[c2][1]:
            grass[c1] = min(c[c2][2] - c[c1][2], grass[c1])

        
    if c[c1][0] == 'E':
            
        if c[c2][0] == 'N' and c[c1][2] - c[c2][2] < c[c2][1] - c[c1][1] and c[c1][2] > c[c2][2] and stopped[c2] > c[c1][2] - c[c2][2]:
            grass[c1] = min(c[c2][1] - c[c1][1], grass[c1])

    
    return 0

n = int(input())
c = [0] * n

for i in range(n):
    c[i] = input().split()
    c[i][1] = int(c[i][1]); c[i][2] = int(c[i][2])

stopped = [9999999999] * n; ans = ['Infinity'] * n
for t in range(n):
    grass = [999999999999] *  n
    for i in range(n):
        for j in range(n):
            checkStopped(i,j)

    
    min_stopped = 9999999999999
    for i in range(n):
        if stopped[i] == 9999999999:
            if grass[i] < min_stopped:
                ind = i
                min_stopped = grass[i]
    
    if min_stopped != 9999999999999:
        stopped[ind] = min_stopped
        ans[ind] = min_stopped

for i in range(n):
    if ans[i] == 999999999999:
        print('Infinity')
    else:
        print(ans[i])

