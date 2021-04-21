# Codeforces Round #304 (Div. 2)
# A. Soldier and Bananas [implemention]
k,n,w = map (int,input().split())
amt = 0 
for i in range(1,w+1): 
    amt = amt+ k*i
if amt <= n : 
    print (0)
else: print(amt - n)