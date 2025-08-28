k,n = map(int,input().split())
cows = input().split()

papers = [0] * k
for i in range(k):
    papers[i] = input().split()

early = dict()
late = dict()
temp_cows = sorted(cows)
for i in range(n):
    early[temp_cows[i]] = set()
    late[temp_cows[i]] = set()
    for j in range(i):
        late[temp_cows[i]].add(temp_cows[j])
    for j in range(i+1,n):
        early[temp_cows[i]].add(temp_cows[j])


for i in range(n):
    for j in range(n):
        if i == j:
            print('B',end = '')
        else:
            flag = True
            for a in range(k):
                ind_1 = papers[a].index(cows[i])
                ind_2 = papers[a].index(cows[j])
                if ind_1 > ind_2 and cows[j] in early[cows[i]]:
                    print(1,end = '')
                    flag = False
                    break
                elif ind_1 < ind_2 and cows[i] in early[cows[j]]:
                    print(0,end = '')
                    flag = False
                    break
            
            if flag:
                print('?',end = '')
    print()