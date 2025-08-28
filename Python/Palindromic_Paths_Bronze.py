n = int(input())
field = [0] * n

for i in range(n):
    s = input()
    field[i] = [0] * n
    for j in range(n):
        field[i][j] = s[j]

print(field)