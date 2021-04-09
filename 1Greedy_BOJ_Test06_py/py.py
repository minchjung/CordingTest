n,k=map(int,input().split());arr=[]
for i in range(n):
    arr.append(int(input()))
arr.sort(reverse=True)
cnt=0
for a in arr:
    if k>=a:
        cnt+=k//a
        k-=a*(k//a)
print(cnt)