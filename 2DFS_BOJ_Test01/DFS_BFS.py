# BFS, DFS 비교 문제 BOJ 1260번 
# n: 총 노드 수 , m : 연결된 간선의 수, v : 탐색 시작 노드 
n,m,v = map(int, input().split()) 
adj= [[] for i in range(n+1)] 
# node 정보 adj 리스트 
for i in range(m) : 
    # node 연결 정보를 한줄씩 input으로 받아 리스트로 저장
    a,b = map(int,input().split()) 
    adj[a].append(b)
    adj[b].append(a)
#DFS
stack = [] 
visited = [] 
stack.append(v)
while stack :
    now = stack.pop() 
    adj[now].sort(reverse=True)
    for i in adj[now]: 
        if i not in visited :
            stack.append(i)
    if now not in visited : 
        visited.append(now)
for i in visited: 
    print(i, end =" ") 

#BFS 
from collections import deque 
q =deque([v])
visited=[] 
while q :
    now = q.popleft()
    adj[now].sort()
    for i in adj[now]:
        if i not in visited : 
            q.append(i)
    if now not in visited :
        visited.append(now)
print()
for i in visited : 
    print(i, end =" ") 