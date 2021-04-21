# Codeforces Round #340 (Div. 2)
# C. Watering Flowers
n,x1,y1,x2,y2 = map(int, input().split())
f1 = [0]*n
f2 = [0]*n
ans = 100000000000000 
def dfs(d1,d2):
    cnt=0; 
    global ans 
    for j in range(n):
        if d1 < f1[j] and d2 < f2[j] : 
            return
        else :
            cnt+=1
    if cnt ==len(f1):
        ans =min(ans,d1**(2)+d2**(2))     
for i in range(n):
    a,b = map(int, input().split()) 
    f1[i]=((a-x1)**(2) +(b-y1)**(2))**(0.5)
    f2[i]=((a-x2)**(2) +(b-y2)**(2))**(0.5)
for i in range(n):
    for j in range(n):
        dfs(f1[i],f2[j])
if(ans*10)%10>=5:
    print(int(ans)+1)
else: print(int(ans))