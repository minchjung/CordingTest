# Codeforces Beta Round #65 (Div. 2)
# A. Way Too Long Words 
# more than 10 == from 11 
n = int (input())
for _ in range(n): 
    word = input()
    if len(word)<=10 : 
        print(word)
    else: 
        arr = list(word)
        print(arr[0]+str(len(word)-2)+arr[-1])