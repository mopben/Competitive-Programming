k,n = map(int,input().split())

cows = input().split()

greater = dict(); less = dict(); equal = dict()
for i in range(n):
    greater[cows[i]] = set()
    less[cows[i]] = set()
    equal[cows[i]] = set()

for i in range(k):
    papers = input().split()
    t_papers = papers.copy()
    t_papers.sort()
    for j in reversed(range(1,n)):
        for a in range(j):
            if t_papers.index(papers[j]) < t_papers.index(papers[a]):
                greater[papers[j]].add(papers[a])
                less[papers[a]].add(papers[j])
            if t_papers.index(papers[j]) > t_papers.index(papers[a]):
                equal[papers[j]].add(papers[a])

for i in range(n):
    for j in equal[cows[i]]:
        greater[cows[i]] = greater[cows[i]].union(greater[j])
        for a in greater[j]:
            less[a].add(cows[i])

for i in range(n):
    for j in range(n):
        if i == j:
            print('B',end = '')
        else:
            if cows[j] in greater[cows[i]]:
                print(1,end = '')
            elif cows[j] in less[cows[i]]:
                print(0,end = '')
            else:
                print('?', end = '')
    
    print()