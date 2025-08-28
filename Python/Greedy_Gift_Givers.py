"""
ID: benqia51
LANG: PYTHON3
TASK: gift1
"""

import sys

sys.stdin = open("gift1.in","r")
sys.stdout = open("gift1.out","w")

n = int(input())
group = []
money = [0] * n

for i in range(n):
    group.append(input())
    
for i in range(n):
    giver = input()
    moneyWithdraw, people = map(int, input().split())
    money[group.index(giver)] -= moneyWithdraw
    
    if people != 0:
        moneyGiven = moneyWithdraw//people
        money[group.index(giver)] += moneyWithdraw % people

    for j in range(people):
        person = input()
        money[group.index(person)] += moneyGiven
        
for i in range(n):
    print(group[i], money[i])