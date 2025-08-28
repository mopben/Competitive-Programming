import sys

#sys.stdin = open("milkorder.in","r")
#sys.stdout = open("milkorder.out","w")
def make_order_pos(pos):
    arr = []
    
    for order_cow in range(m):
        for pos_cow in range(k):
            if ordering[order_cow] == pos[pos_cow][0]:
                arr.append(pos[pos_cow][0])
    
    return arr

def check(arr):
    prev = 0; prev_i = 0
    for i in order_pos:
        counter = 0
            
        #find spaces between previous pos and cur pos in the order
        for j in range(prev,arr.index(i)):
            if arr[j] == -1:
                counter += 1
            
        #find spaces between previous pos and cur pos in the hierarchy
        counter2 = ordering.index(i) - prev_i
        if counter < ordering.index(i) - prev_i:
            return False
        
        prev_i = ordering.index(i) 
        prev = arr.index(i)

    return True

n,m,k = map(int,input().split())

ordering = [int(x) for x in input().split()]
p = [0] * n

for i in range(k):
    p[i] = [int(x) for x in input().split()]

order = [-1] * n

for i in range(k):
    order[p[i][1]-1] = p[i][0]

#simulate
for loc_1 in range(n):
    if order[loc_1] == -1:
        o = order.copy(); temp_p = p.copy()
        o[loc_1] = 1; temp_p.append([1,loc_1])
       
        order_pos = make_order_pos(temp_p)
        if check(o):
            print(loc_1+1)
            break