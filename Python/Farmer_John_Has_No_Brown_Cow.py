def num_choices(pos1,pos2):
    total = 1
    for p in range(pos1,pos2+1):

        total *= len(adj[p])
    return total

def get_k_cow(k):
    s = ''
    for p in range(len(adj)):
        if p > 0:
            s = s + ' '
        s = s + adj[p][k // num_choices(p+1,len(adj)-1)]
        k = k % num_choices(p+1,len(adj)-1)
    
    return s

n,m = map(int,input().split())

adj = [0] * 3
for i in range(len(adj)):
    adj[i] = set([])
    
for i in range(n):

    s = input().split()
    for j in range(4,len(s)-1):
        if s[j] not in adj:
            adj[j-4].add(s[j])

for i in range(len(adj)):
    adj[i] = list(adj[i])
    adj[i].sort()

print(get_k_cow(m))
print(adj)