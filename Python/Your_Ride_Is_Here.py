"""
ID: benqia51
LANG: PYTHON3
TASK: ride
"""
import sys

sys.stdin = open("ride.in","r")
sys.stdout = open("ride.out","w")

comet = input()
group = input()

cometTotal = 1
groupTotal = 1

for i in range(len(comet)):
    cometTotal *= ord(comet[i]) - 64

for i in range(len(group)):
    groupTotal *= ord(group[i]) - 64
    
if cometTotal % 47 == groupTotal % 47:
    print("GO")
else:
    print("STAY")