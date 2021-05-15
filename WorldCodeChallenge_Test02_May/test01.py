def solution(left, right): 
    arr =[0]*1001
    arr[1]=1
    arr[2]=0

    def check(n):
        n = int(n)
        div = []
        div_back = [] 

        for i in range(1, int(n**(1/2)) + 1): 
            if (n % i == 0):            
                div.append(i)
                if (i != (n // i)): 
                    div_back.append(n//i)
        return len(div + div_back[::-1])%2

    for i in range(3,1001):
        arr[i]=check(i)
    ansSum = 0 
    for i in range(left,right+1): 
        if arr[i]==0 : ansSum+=i 
        else : ansSum-=i 
    return ansSum 