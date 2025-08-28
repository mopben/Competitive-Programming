import math
methods = 0
n = int(input())        

for s1 in range(100):
    for s2 in range(100):
        for s3 in range(100):
            a1 = s1 ** 2
            a2 = s2 ** 2
            a3 = s3 ** 2
            PreTotalValue = a1 + a2 + a3
            a4 = n - PreTotalValue
            if a4 <0:
                pass
            else:
                A4 =math.sqrt(a4)
                A4 = int(A4)
                if A4 % 2 == 0:
                    if a4 + a3 + a2 + a1 = n:
                        methods += 1
print(methods)