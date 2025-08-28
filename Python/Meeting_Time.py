import sys
sys.stdin = open("meeting.in","r")
sys.stdout = open("meeting.out","w")

def find_times(graph,node,counter):
    global b_times
    global e_times
    
    if node == n:
        if graph == b_graph:
            b_times.add(counter)
        else:
            e_times.add(counter)
        
    for k in range(len(graph[node])):
        temp_counter = counter
        temp_counter += graph[node][k][1]
        find_times(graph,graph[node][k][0],temp_counter)
        
    return 0
n,m = map(int,input().split())

#make graph-------------------------------------------
b_graph = dict(); e_graph = dict()
for i in range(1,n+1):
    b_graph[i] = []; e_graph[i] = []
    
#add edges-----------------------------------------------
for i in range(m):
    f1,f2,p1,p2 = map(int,input().split())
    
    b_graph[f1].append([f2,p1]); e_graph[f1].append([f2,p2])

b_times = set(); e_times = set()

find_times(b_graph,1,0)
find_times(e_graph,1,0)

inter = b_times.intersection(e_times)

if inter:
    print(min(inter))
else:
    print("IMPOSSIBLE")