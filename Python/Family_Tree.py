#In this problem, we're given a tree and have to find the relationship between two nodes on the tree
import sys

#the cow that doesnt have a parent is the root
def find_root():
    cows = set()
    for k in graph.keys():
        cows.update(graph[k]) #find all the cows

    for k in graph.keys():
        if k not in cows: #find the cow that doesn't have a parent
            value = k
            return value

#make the tree------------------------------
def insert(start):
    tree = Node(start)
    if start not in graph.keys():
        return tree
    for k in graph[start]:
        tree.add_child(insert(k))

    return tree

#class node---------------------------
class Node:
    def __init__(self,data):
        self.children = []
        self.data = data
        self.parent = None
     
    def add_child(self,child):
        child.parent = self
        self.children.append(child)

    #traverse through tree to find the ancestors of the two cows
    def traverse(self):
        if len(self.children) <= 0:
            return 0
        else:
            for k in self.children:
                if k.data == cow1:
                    k.find_anc()
                elif k.data == cow2:
                    k.find_anc2()
                k.traverse()
            return 0

    #find ancestors of the first cow
    def find_anc(self):
        if self.parent != None:
            anc1.append(self.parent.data)
            self.parent.find_anc()

    #find ancestors of the second cow
    def find_anc2(self):
        if self.parent != None:
            anc2.append(self.parent.data)
            self.parent.find_anc2()

#sys.stdin = open("family.in","r")
#sys.stdout = open("family.out","w")
#take inputs and update dictionary-----------------------------
n,cow1,cow2 = input().split()
n = int(n)
graph = dict()
for i in range(n):
    c1,c2 = input().split()

    if c1 in graph:
        graph[c1].update(set([c2]))
    else:
        graph.update({c1: set([c2])})

#make tree----------------------------------

root = None
root = find_root()
family_tree = insert(root)
anc1 = []
anc2 = []

family_tree.traverse() #find ancestors from order of closest to farthest

#find relationship between two cows----------------
print(anc1)
print(anc2)
#siblings-------------------------------------
if len(anc1) > 0 and len(anc2) > 0:
    if anc1[0] == anc2[0]:
        print("SIBLINGS")
        sys.exit()

#direct ancestor---------------------------------------------------------------
if cow2 in anc1:
    relation = anc1.index(cow2)
    if relation == 0:
        print(cow2,"is the mother of",cow1)
        sys.exit()
    if relation == 1:
        print(cow2,"is the grand-mother of",cow1)
        sys.exit()
    if relation >= 2:
        print(f"{cow2} is the","great-"*(relation-1)+"grand-mother of",cow1)
        sys.exit()

if cow1 in anc2:
    relation = anc2.index(cow1)
    if relation == 0:
        print(cow1,"is the mother of",cow2)
        sys.exit()
    if relation == 1:
        print(cow1,"is the grand-mother of",cow2)
        sys.exit()
    if relation >= 2:
        print(cow1, "is the","great-"*(relation-1)+"grand-mother of",cow2)
        sys.exit()

#aunt------------------------------------------------------------------------------

if len(anc2) > 0:
    if anc2[0] in anc1:
        relation = anc1.index(anc2[0])
        if relation == 1:
            print(cow2,'is the aunt of',cow1)
            sys.exit()
        if relation >= 2:
            print(cow2,'is the','great-'*(relation-1)+"aunt of",cow1)
            sys.exit()
            
if len(anc1) > 0:
    if anc1[0] in anc2:
        relation = anc2.index(anc1[0])
        if relation == 1:
            print(cow1,'is the aunt of',cow2)
            sys.exit()
        if relation >= 2:
            print(cow1,'is the','great-'*(relation-1)+"aunt of",cow2)
            sys.exit()

#cousin or not related----------------------------------------------
tempAnc1 = set(anc1)
tempAnc2 = set(anc2)

if len(tempAnc1.intersection(tempAnc2)) > 0:
    print("COUSINS")
else:
    print("NOT RELATED")
