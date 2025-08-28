def find_pos():
    arr = []
    for i in range(m):
        for j in range(k):
            if order[i] == pos[j][0]:
                arr.append(pos[j][0])
                break
            
            if order[i] == 1:
                arr.append(1)
                break
    return arr

def check_valid():
    if not included:
        return True
    
    for i in range(m):
        if i > order.index(1):
            
            if t_milk.index(order[i]) < pos_1:
                return False
                        
        if i < order.index(1):
            if t_milk.index(order[i]) > pos_1:
                return False
    
    return True

def check(arr):
    prev = 0; prev_i = 0
    for i in pos_order:
        counter = 0
            
        #find spaces between previous pos and cur pos in the order
        for j in range(prev,arr.index(i)):
            if arr[j] == -1:
                counter += 1
            if i == prev:
                counter = 9999999999
        #find spaces between previous pos and cur pos in the hierarchy
        counter2 = order.index(i) - prev_i
    
        if counter < counter2:
            return False
        
        prev_i = order.index(i) 
        prev = arr.index(i)

    return True

n,m,k = map(int,input().split())

order = [int(x) for x in input().split()]

milk = [-1] * n
pos = [0] * k
for i in range(k):
    pos[i] = [int(x) for x in input().split()]
    pos[i][1] -= 1
    milk[pos[i][1]] = pos[i][0]

included = False
if 1 in order:
    included = True
    
for pos_1 in range(n):
    t_milk = milk.copy()
    if t_milk[pos_1] == -1 and check_valid():
        t_milk[pos_1] = 1
        pos_order = find_pos()
        pos_order_set = set(pos_order)
        if check(t_milk):
            print(pos_1 + 1)
            break

        
        