import numpy as np

rows, cols = map(int, input().strip().split(','))

# 创建边界值为1的2维数组
array = np.ones((rows, cols))

# 将内部值设为0
array[1:-1, 1:-1] = 0

print(array)
