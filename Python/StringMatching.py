
s = input()
t = input()
ans = ''
counter = 0
for i in range(len(s)):

    ans = ans + s[i]
    if len(ans) >= len(t):
        if ans[len(ans) - len(t):len(ans)] == t:
            counter += 1

print(counter)