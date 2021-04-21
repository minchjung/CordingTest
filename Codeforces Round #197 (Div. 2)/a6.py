# A. Helpful Maths
# implementation  
eq= list(input().split("+"))
eq.sort()
for i,e in enumerate(eq): 
    if i != len(eq)-1 : print(e+"+",end="")
    else: print(e)