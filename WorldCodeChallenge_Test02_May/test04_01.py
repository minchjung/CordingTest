from collections import deque 
class Node : 
    
    node= 0 
    val = 0 
    parents = 0 

    def __init__(self,node,val):
        self.node=node 
        self.val=val

    def getNode(self):
        return self.node         
    
    def getVal(self): 
        return self.val
    
    def getParents(self):
        return self.parents


def solution(values,edges,quries): 
    arr = [] 
    for i in range(len(values)) : 
        arr.append(Node(i,values[i]))
    for e in edges: 
        arr[e[1]-1].parents=e[0]-1

    def firstQurie(root): 
        vis = [0]*(len(arr)+1) 
        q = deque() 
        q.append(root)
        vis[root-1]=1 
        ansSum = 0
        while q : 
            now = q.popleft(); 
            for nodeObj in arr : 
                print(nodeObj.node)
                if vis[nodeObj.node] !=0 : continue 
                if nodeObj.parents ==root -1 and nodeObj.node!=root -1 : 
                    ansSum+= nodeObj.val
                    vis[nodeObj.node]=1
        return ansSum
    
    def secondQurie(u,w): 
        vis = [0]*(len(arr)+1)
        q = deque() 
        q.append(u-1)
        while q : 
            now = q.popleft() 
            arr[arr[u-1].parents].val=arr[u-1].val
            arr[u-1].val = 0 
            q.append(arr[u-1].parents)

    result = []
    for querie in quries : 
        if querie[1]==-1 : 
            result.append(firstQurie(querie[0]))
            
        else : secondQurie(querie[0], querie[1])

solution([1,10,100,1000,10000],[[1,2],[1,3],[2,4],[2,5]],[[1,-1],[2,-1],[3,-1],[4,-1],[5,-1],[4,1000],[1,-1],[2,-1],[3,-1],[4,-1],[5,-1],[2,1],[1,-1],[2,-1],[3,-1],[4,-1],[5,-1]])