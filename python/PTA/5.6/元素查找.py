import numpy as np

def find_closest_value(matrix, target):
    matrix = np.array(matrix)
    flattened_matrix = matrix.flatten()
    closest_value = flattened_matrix[np.abs(flattened_matrix - target).argmin()]
    return closest_value

# 读取输入
matrix = [[0, 1, 2, 3], [4, 5, 6, 7]]
target = 5.3

# 查找最接近的数
closest_value = find_closest_value(matrix, target)

# 输出结果
print("num =", closest_value)