import numpy as np


# 定义目标函数
def objective_function(r, theta):
    f = np.sum((r - 100) ** 2) + np.sum((theta - np.arange(0, 360, 360 / 9)) ** 2)
    return f


# 定义目标函数的梯度
def gradient(r, theta):
    grad_r = 2 * (r - 100)
    grad_theta = 2 * (theta - np.arange(0, 360, 360 / 9))
    return grad_r, grad_theta


# 初始化无人机位置
r = np.array([0, 100, 98, 112, 105, 98, 112, 105, 98, 112], dtype=np.float64)
theta = np.array([0, 0, 40.10, 80.21, 119.75, 159.86, 199.96, 240.07, 280.17, 320.28])

# 设置学习率
alpha = 0.1

# 执行梯度下降
for i in range(21):
    # 计算梯度
    grad_r, grad_theta = gradient(r[1:], theta[1:])

    # 更新无人机的位置
    r[1:] -= alpha * grad_r
    theta[1:] -= alpha * grad_theta

    # 计算目标函数值
    f = objective_function(r[1:], theta[1:])

    # 输出结果
    print(f'Iteration {i}: Objective function value: {f}')

# 打印无人机的最后位置
    print(f'Final position of the drones:')
    for i in range(10):
        print(f'Drone {i}: r = {r[i]}, theta = {theta[i]}')
