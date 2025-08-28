import sys

sys.stdin = open("backforth.in","r")
sys.stdout = open("backforth.out","w")

b1 = [int(x) for x in input().split()]
b2 = [int(x) for x in input().split()]

results = set()

for a in range(10):
    tempB1 = b1.copy(); tempB2 = b2.copy(); t1 = 1000
    t1 -= tempB1[a]
    tempB2.append(tempB1[a])
    tempB1.pop(a)
    for b in range(11):
        temp2B1 = tempB1.copy(); temp2B2 = tempB2.copy(); t3 = t1
        t3 += temp2B2[b]
        temp2B1.append(temp2B2[b])
        temp2B2.pop(b)
        for c in range(10):
            temp3B1 = temp2B1.copy(); temp3B2 = temp2B2.copy(); t5 = t3
            t5 -= temp3B1[c]
            temp3B2.append(temp3B1[c])
            temp3B1.pop(c)
            
            for d in range(11):
                temp4B1 = temp3B1.copy(); temp4B2 = temp3B2.copy(); t7 = t5
                t7 += temp4B2[d]
                temp4B1.append(temp4B2[d])
                temp4B2.pop(d)
                
                results.add(t7)
                
                
print(len(results))