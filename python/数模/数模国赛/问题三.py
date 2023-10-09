import math
import pandas as pd


def calculator(beta, ds):
    distance_x = []
    # 给定矩形的参数
    a = 1.9993  # 矩形的高度（上下两条边的y值之差的一半）
    b = 1  # 矩形的宽度（左右两条边的x值之差的一半）
    # 直线参数
    k = math.tan(beta - math.pi / 2)  # 直线斜率
    b_line = ds / math.sin(beta)  # 直线的截距
    linelength = 0
    # 计算直线与四条边的交点
    intersections = []
    # 计算直线与y=a的交点
    x_inter = (a - b_line) / k
    if -b <= x_inter <= b:
        intersections.append((x_inter, a))
    # 计算直线与y=-a的交点
    x_inter = (-a - b_line) / k
    if -b <= x_inter <= b:
        intersections.append((x_inter, -a))
    # 计算直线与x=b的交点
    y_inter = k * b + b_line
    if -a <= y_inter <= a:
        intersections.append((b, y_inter))
    # 计算直线与x=-b的交点
    y_inter = k * -b + b_line
    if -a <= y_inter <= a:
        intersections.append((-b, y_inter))

    # 显示满足条件的交点坐标和距离
    print('满足条件的交点坐标和距离:')
    for i in range(len(intersections)):
        for j in range(i + 1, len(intersections)):
            x1, y1 = intersections[i]
            x2, y2 = intersections[j]
            # 计算两个交点之间的距离
            linelength = math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2)
            # 显示交点坐标和距离
            print(f'交点 {i + 1} 和交点 {j + 1} 之间的距离为 {linelength:.2f}')
        x, y = intersections[i]
        # 计算交点到 x 轴的距离
        distance_x_axis = abs(y) / math.sin(beta)
        distance_x.append(distance_x_axis)
        # 显示交点坐标和距离
        print(f'交点 {i + 1}: 坐标 ({x:.2f}, {y:.2f}), 距离 x 轴的距离为 {distance_x_axis:.2f}')

    return linelength, distance_x


def question31(beta_deg, d, ds):
    distance_x = []
    # 模型参数
    theta_deg = 120  # 换能器开角 （度）
    alpha_deg = 1.5  # 坡度（度）
    D0 = 110 / 1852  # 海水深度（米）
    l = 0  # 相当于第二问中与海域中心点的距离,写这个只是为了说明这个变量的意义
    sumlinelength = 0
    d1 = []
    beta1 = []
    W01 = []
    eta1 = []

    theta = math.radians(theta_deg)
    alpha = math.radians(alpha_deg)
    beta = math.radians(beta_deg)
    gamma = math.atan(math.sin(beta) * math.tan(alpha))
    alpha = gamma

    # 测线距中心点处的距离
    linelength, distance_x = calculator(beta, ds)
    sumlinelength += linelength

    for i in range(2):
        l = distance_x[i] - d
        # D为换能器处的海水深度
        D1 = D0 - l * math.tan(alpha)
        # 计算波束的覆盖宽度
        x0L = D1 * (math.sin(theta / 2) / math.sin(math.pi / 2 - alpha - theta / 2))
        x0R = D1 * (math.sin(theta / 2) / math.sin(math.pi / 2 + alpha - theta / 2))
        W0 = x0L + x0R

        # 测线距中心点处的距离
        l = l + d
        # D为换能器处的海水深度
        D2 = D0 - l * math.tan(alpha)
        # 计算波束的覆盖宽度
        x1L = D2 * (math.sin(theta / 2) / math.sin(math.pi / 2 - alpha - theta / 2))
        x1R = D2 * (math.sin(theta / 2) / math.sin(math.pi / 2 + alpha - theta / 2))
        W1 = x1L + x1R

        # 计算相邻条带之间的重叠率
        eta = (x0R + x1L - d / math.cos(alpha)) / W1
        eta1.append(eta)
        beta1.append(math.degrees(beta))
        d1.append(i * 0.3)
        W01.append(W0)

    return pd.DataFrame({'beta_deg': beta1, 'W01': W01, 'eta1': eta1, 'linelength': sumlinelength})


beta_deg = 30  # 你可以设置任何合适的初始值
ls = 0  # 该测线与离中心的测线的距离，由此可以依次确定相邻两测线间距
ds = 0
d = 0.1  # 间距

for i in range(100):
    df = question31(beta_deg, d, ds)
    ls += df['linelength'].sum()
    ds = ds + d
    print(d)

# 将数据写入 Excel 表格
filename = 'data2.xlsx'
df.to_excel(filename, index=False)
