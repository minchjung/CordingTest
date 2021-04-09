n = int(input())
ans = 0 ; 
three = [3,6,9,12] # 결론은 최소 공배수 15 전까지는 3의 몫이 최저해 
# 15 이상부터 5로 나눠 떨어지면 몫이 최저값 
# 그렇지 않으면 나머지가 3으로 떨어졌을때가 최저값 
# 이것도 아니라면 5개 짜리 봉지를 먼저 만들어 보고 (5로 빼주고 계속해서 재귀호출)  
# 12 이하까지 만들어졌을때 3,6,9,12 중 하나가 만들어지면 
# 3으로 나눈값 + 5를 뺀 횟수 (재귀 호출 횟수)=최저값   
# 그외는 만들 수 없는 값.
def solution(n):
    global ans
    global three
    if n in three : 
        ans +=n //3
    elif n < 5 : 
        if n % 3 !=0 : 
            ans = -1
        else : 
            ans += 1 
    else : 
        if (n % 5)!=0: 
            if (n % 5) % 3 ==0: 
                ans += n //5 + (n % 5) //3 
            else : 
                if(n-5>0):
                    ans+=1
                    solution(n-5)
        else : 
            ans += n //5
solution(n)
print(ans)