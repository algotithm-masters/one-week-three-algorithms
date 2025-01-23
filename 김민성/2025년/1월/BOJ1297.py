import math

'''
세로와 가로의 비율: H:W
이를 H=kx, W=ky로 표현할 수 있다. (k는 비례 상수)

피타고라스 정리에 의해
=> (kx)2+(ky)2=D2 가 되고
=> k에 따라 정리하면 k2(x2+y2)=D2 가 된다.
'''

D, H, W = map(int, input().strip().split(" "))

# 직각삼각형의 비례 상수 구하기
k = math.sqrt((D ** 2) / ((H ** 2) + (W ** 2))) 

# 각각의 대입
height = math.floor(k * H)
width = math.floor(k * W)

print(f'{height} {width}')