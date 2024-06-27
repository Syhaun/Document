x,y = map(int, input().split(','))    #圆c的中心坐标
r = int(input())        #圆c的半径
a,b = map(int, input().split(','))    #需要判断的点
if a*a+b*b<= r*r:       #如果点在圆内
    print("( %d , %d )在圆内"%(a,b))
else:                   #点不在圆内
    print("( %d , %d )在圆外"%(a,b))