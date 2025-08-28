tree = [0] * 3

tree[1] = 'A'

tree[0] = [0] * 3
tree[0][1] = 'B'
tree[0][0] = [0] * 3
tree[0][0][1] = 'D'

tree[2] = [0] * 3
tree[2][1] = 'C'
tree[2][0] = [0] * 3
tree[2][0][1] = 'E'
tree[2][2] = [0] * 3
tree[2][2][1] = 'F'
print(tree)