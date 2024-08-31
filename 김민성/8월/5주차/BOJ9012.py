import sys

#VPS가 되는 조건
# 1. 여는 괄호의 개수와 닫는 괄호의 개수가 일치해야 한다.
# 2. 완료되지 않은 괄호가 존재해선 안된다. ex. ")("
# => 처음부터 검사했을 때, 닫는 괄호가 더 많은 순간 VPS가 아니다.
#    또, 종료 시까지 여는 괄호의 개수가 남았다면 VPS가 아니다.

def isVPS(ps):
    open_parenthesis_count = 0
    for p in ps:
        # 1. 괄호의 개수 체크
        if p  == '(':
            open_parenthesis_count += 1
        elif p  == ')':
            open_parenthesis_count -= 1
        
        if open_parenthesis_count == -1:
            return False
    
    if open_parenthesis_count > 0:
        return False
            
    return True



input = sys.stdin.readline
N = int(input())

for _ in range(N):
    output = "YES" if isVPS(input()) else "NO"
    print(output)

