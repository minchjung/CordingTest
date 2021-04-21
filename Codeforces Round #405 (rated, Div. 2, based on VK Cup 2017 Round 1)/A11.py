# Codeforces Round #405 (rated, Div. 2, based on VK Cup 2017 Round 1)
# A. Bear and Big Brother
a,b = map(int, input().split())
cnt =0
while a <= b: 
    a *=3
    b *=2
    cnt+=1
print(cnt)