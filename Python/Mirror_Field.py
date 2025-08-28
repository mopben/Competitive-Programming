n,m = map(int,input().split())
field = [0] * m

for i in range(m):
    field[i] = [0] * n
    s = input()
    print(s)
    for j in range(n):
        field[i][j] = s[j]
        print(field[i])
print(field)