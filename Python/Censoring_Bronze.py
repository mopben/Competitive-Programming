import sys

sys.stdin = open("censor.in","r")
sys.stdout = open("censor.out","w")
s = input()
t = input()
ans = ''

for i in range(len(s)):

    ans = ans + s[i]
    if len(ans) >= len(t):
        if ans[len(ans) - len(t):len(ans)] == t:
            ans = ans[0:len(ans)-len(t)]

print(ans)