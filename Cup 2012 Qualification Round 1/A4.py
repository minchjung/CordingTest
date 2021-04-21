# VK Cup 2012 Qualification Round 1
# A. Next Round
# Implementation
n, k = map(int, input().split())
arr = list( map(int, input().split()) ) 
cut = arr[k-1]
cnt=0
for i in range(len(arr)):
    if arr[i] >= cut and arr[i]>0: 
        cnt+=1
print(cnt)