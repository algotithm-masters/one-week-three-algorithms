import sys
input = sys.stdin.readline

N = int(input())

stack = []
for _ in range(N):
    command = input().strip()
    operator = command.split(" ")[0]

    if operator == 'push':
        operand = command.split(" ")[1]
        stack.append(operand)
    elif operator == 'pop':
        try:
            print(stack.pop())
        except:
            print(-1)
    elif operator == 'size':
        print(len(stack))
    elif operator == 'empty':
        print(1 if len(stack) == 0 else 0)
    elif operator == 'top':
        try:    
            print(stack[-1])
        except:
            print(-1)
    else:
        raise print("잘못된 값이 입력되었습니다.")