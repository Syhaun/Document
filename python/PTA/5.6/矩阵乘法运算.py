import numpy as np
x_str = input().strip()
y_str = input().strip()
x = np.array(eval(x_str))
y = np.array(eval(y_str))
if np.ndim(x)==1 and np.ndim(y)==1:
        result = np.dot(x,y)
        print(result)
elif np.ndim(x) ==2 and np.ndim(y) == 2:
        if x.shape[1] != y.shape[0]:
                print("输入格式有错误!")
        else:
                result = np.dot(x, y)
                print(result)
else:
        print("输入格式有错误!")