from collections import deque 
def solution(values,edges,quries): 
    arr = [ [] for _ in range(len(values)+1) ]  
    for i, e in enumerate(edges): 
        arr[e[0]-1].append(e[1]-1)

    def firstQurie(root): 
        vis = [0]*(len(arr)+1) 
        q = deque() 
        q.append(root)
        vis[root]=1 
        ansSum = values[root]
        while q : 
            now = q.popleft(); 
            for nxt in arr[now]: 
                if vis[nxt] !=0 : continue 
                vis[nxt]=1 
                ansSum+=values[nxt]
                q.append(nxt)
        return ansSum
    
    def secondQurie(u,w): 
        vis = [0]*(len(arr)+1)
        q = deque() 
        q.append(u)
        while q : 
            now = q.popleft();
            if now == 0 : 
                values[now]=w 
                q.clear() 
                break  
            for parentIdx, nodeInf in enumerate(arr): 
                if now not in nodeInf or vis[parentIdx]!=0:continue 
                vis[parentIdx]=1 
                values[now]=values[parentIdx]
                q.append(parentIdx)
    result = []
    for querie in quries : 
        if querie[1]==-1 : 
            result.append(firstQurie(querie[0]-1))
        else : secondQurie(querie[0]-1, querie[1])
    return result
print(solution([1,10,100,1000,10000],[[1,2],[1,3],[2,4],[2,5]],[[1,-1],[2,-1],[3,-1],[4,-1],[5,-1],[4,1000],[1,-1],[2,-1],[3,-1],[4,-1],[5,-1],[2,1],[1,-1],[2,-1],[3,-1],[4,-1],[5,-1]]))