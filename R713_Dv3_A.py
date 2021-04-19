# R713_Div3_A[Spy Detected]p01
from collections import Counter
t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int, input().split()))
    spy =Counter(arr).most_common()[1][0]
    print(arr.index(spy)+1)
