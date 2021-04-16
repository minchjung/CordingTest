# 사칙 연산만 수행
def cal(n1,n2):
    tem=set()
    tem.add(n1+n2)
    tem.add(n1-n2)
    tem.add(n1*n2)
    if n2 !=0:
        tem.add(n1//n2)

    return tem 
# 담겨 있는 모든 수들의 조합을 짜서 사칙 연산 호출
def start(set1,set2):
    tem=set()
    for a in set1 : 
        for b in set2: 
            tem = tem | (cal(a,b))
            tem = tem | (cal(b,a))
    return tem
# 입력값 받고 세팅 및 실행
def solution(n,target): 
    result =[set() for i in range(9)]
    result[1].add(n)

    if target ==0 : 
        return -1 
    if target == n :
        return 1 
    # 가능한 모든 수 구하기
    # n이 index개 일때 사칙연산으로 얻을 수 있는 가능한 모든 수  
    for i in range(2,9):
        for j in range(1,i//2+1):
            # ex ) 6개일때= 1개일때 ,5개일때 얻었던 모든 수들의 사칙연산 조합 
                        #   3개일때, 3개일때 얻었던 모든 수들의 사칙연산 조합 
                        #   2개일때, 4개일때 얻었던 모든 수들의 사칙연산 조합 
            result[i] = (start(result[j],result[i-j]))
            result[i].add(int(str(n)*i))
            if target in result[i]:
                return i
    return -1
