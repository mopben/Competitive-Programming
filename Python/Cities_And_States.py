import sys

sys.stdin = open("citystate.in","r")
sys.stdout = open("citystate.out","w")
n = int(input())
locations = {}

for i in range(n):
    city,state = input().split()
    if city[0:2] != state:
        key = city[0:2] + state
        if key not in locations:
            locations.update({key: 0})
        locations.update({key: locations.get(key) +1})

counter = 0
for key in set(locations.keys()):
    invertedKey = key[2:4] + key[0:2]
    if invertedKey in locations:
        counter += locations.get(key) * locations.get(invertedKey)

print(counter//2)
