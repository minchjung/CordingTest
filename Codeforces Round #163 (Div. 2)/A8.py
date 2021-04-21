# Codeforces Round #163 (Div. 2)
#  A, Stones on the Table [implement] 
input()
stack = list( input() )
end = [stack.pop()]
cnt = 0 ; 
while stack: 
    if end[-1] != stack[-1] : 
        end.append(stack.pop())
    else: 
        stack.pop()
        cnt +=1 
print(cnt)