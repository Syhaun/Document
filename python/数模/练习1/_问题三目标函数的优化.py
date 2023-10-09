import numpy as np
import math


def calculate_angle(p1, p2, p0):
    """
    计算角度的函数
    :param p1: 第一个点的坐标
    :param p2: 第二个点的坐标
    :param p0: 原点的坐标
    :return: 返回角度的值
    """
    v1 = np.array(p1) - np.array(p0)
    v2 = np.array(p2) - np.array(p0)

    angle = math.atan2(np.linalg.det([v1, v2]), np.dot(v1, v2))
    return angle


def find_angle_ranges(R, r, angle_step):
    """
    寻找角度范围的函数
    :param R: 圆的半径
    :param r: 移动半径
    :param angle_step: 角度步长
    """
    # 初始化角度范围
    min_angle_a = math.pi
    max_angle_a = -math.pi
    min_angle_b = math.pi
    max_angle_b = -math.pi

    # 根据F1的初始位置计算圆心坐标
    center = (0, 0)
    F1 = (r, 0)
    F0 = center

    # 遍历Fi和Fk组合
    for i in range(2, 10):
        for j in range(2, 10):
            if i != j:
                Fi = (r * math.cos(2 * math.pi * (i - 1) / 8), r * math.sin(2 * math.pi * (i - 1) / 8))
                Fk = (r * math.cos(2 * math.pi * (j - 1) / 8), r * math.sin(2 * math.pi * (j - 1) / 8))

                # 移动F1并计算角度
                for angle in np.arange(0, 2 * math.pi, angle_step):
                    F1 = (r * math.cos(angle), r * math.sin(angle))
                    angle_a = calculate_angle(Fi, F1, F0)
                    angle_b = calculate_angle(Fk, F1, F0)

                    # 更新角度范围
                    min_angle_a = min(min_angle_a, angle_a)
                    max_angle_a = max(max_angle_a, angle_a)
                    min_angle_b = min(min_angle_b, angle_b)
                    max_angle_b = max(max_angle_b, angle_b)

    # 输出结果
    print("角度范围:")
    print("角a:", min_angle_a, "至", max_angle_a)
    print("角b:", min_angle_b, "至", max_angle_b)


# 设置参数
R = 1.0  # 圆的半径
r = 0.1 * R  # 移动半径
angle_step = 0.01  # 角度步长

# 调用函数寻找角度范围
find_angle_ranges(R, r, angle_step)