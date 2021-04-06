n,m = map(int, input().split()) # n 행 (세로), m: 열 (가로)
graph = [list(map(int, input().split() )) for i in range(n)] # 초기 맵 
temp = [[0]*m for i in range(n)]
answer =0;
xd = [0,0,1,-1] 
yd = [1,-1,0,0]
def propagation(dx,dy):
    for i in range(4):
        dx = dx + xd[i]
        dy = dy + yd[i]
        if(0 <= dx  < m and 0 <= dy < n ):
            if temp[dx][dy] ==0:
                temp[dx][dy] =2 
                propagation(dx,dy) 
def getCnt():
    safe=0
    for i in range(n):
        for j in range(m):
            if temp[i][j] ==0: 
                safe+=1
    return safe

def dfs(cnt):
    global answer
    if cnt==3:
        for i in range(n):
            for j in range(m):
                temp[i][j]=graph[i][j]
        for i in range(n):
            for j in range(m):
                if temp[i][j]==2:
                    propagation(i,j)
        answer = max(answer, getCnt())                
        return 
    for i in range(n):
        for j in range(m): 
            if graph[i][j] ==0:
                cnt+=1
                graph[i][j] = 1 
                dfs(cnt)
                cnt-=1 
                graph[i][j] = 0 
dfs(0)
print(answer)