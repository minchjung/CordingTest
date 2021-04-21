# Codeforces Round #143 (Div. 2)
# A. Team 
# Greedy, brute force
cnt=0
for _ in range(int(input())) : 
    arr =list( map(int, input().split()) )
    if sum(arr)>=2 :
        cnt+=1
print(cnt)       