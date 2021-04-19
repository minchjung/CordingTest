# R713_Div3_A[Strange_Table]p02 
# math *800
t = int( input() )
for _ in range(t):
    n, m, x  = map(int, input().split())
    mok  = x // n 
    rem =  x % n
    if x ==1: 
        print(1)
    else:
        if rem ==0 :
            ans = (n-1) * m + mok  
            print(ans)
        else : 
            ans = (rem-1) * m + mok +1 
            print(ans)