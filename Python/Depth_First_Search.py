def dfs(node):
    visCount = 1
    visited.append(node)
    for i in range(len(graph[node])):
        if graph[node][i] not in visited:
            visCount += dfs(graph[node][i])
    return visCount

graph = {1:[2,3,4],
         2:[1,5,6],
         3:[2,4],
         4:[1,3],
         5:[6],
         6:[5]
         }

visited = []
keys = list(graph.keys())
print(dfs(keys[0]))
