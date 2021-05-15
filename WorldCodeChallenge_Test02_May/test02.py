from collections import deque 
def solution(x): 
    def gogo(num): 
        binX=deque()
        binY=deque()
        for a in  list(str(bin(x))): binX.append(a)
        for b in list(str(bin(num))): binY.append(b)
        for _ in range(2) : 
            binX.popleft()
            binY.popleft()
        
        cnt=0
        while binX and binY: 
            nowX = binX.pop() 
            nowY = binY.pop()
            if nowX != nowY : cnt+=1
        while binY:
            binY.pop()
            cnt+=1 
        return cnt 

    k = 1
    while True : 
        cntAns=gogo(x+k)
        if cntAns <=2 : return x+k 
        k+=1
# print(solution(2)) 
# print(solution(7)) 

#  답3
#  답11