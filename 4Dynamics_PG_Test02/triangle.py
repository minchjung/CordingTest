def solution(triangle):
    for i in range(len(triangle)-1, 0, -1):
        base =triangle[i]
        top = triangle[i-1]
        for j in range(len(top)):
            top[j]=max(top[j] + base[j], top[j] +base[j+1])
    return triangle[0][0]