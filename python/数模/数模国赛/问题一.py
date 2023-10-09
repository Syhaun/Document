import math

# 参数
open_angle_deg = 120  # 开角，单位：度
slope_deg = 1.5       # 坡度，单位：度
depth = 70            # 海水深度，单位：米
distances = [-800, -600, -400, -200, 0, 200, 400, 600, 800]  # 测线距中心点处的距离，单位：米

# 将角度转换为弧度
open_angle_rad = math.radians(open_angle_deg)
slope_rad = math.radians(slope_deg)

# 初始化覆盖宽度和重叠率列表
cover_widths = [0]  # 初始位置的覆盖宽度为0
overlap_rates = ["--"]  # 初始位置的重叠率为--

# 计算每个位置的坡面上的水平距离（h）
horizontal_distances = [dist * math.tan(slope_rad) for dist in distances]

# 计算覆盖宽度（W）和相邻条带之间的重叠率（η），从第二个位置开始计算
for i in range(1, len(distances)):
    h = horizontal_distances[i]
    W = 2 * h * math.tan(open_angle_rad / 2)
    d = distances[i] - distances[i - 1]
    if d == 0:
        overlap_rate = "--"
    else:
        overlap_rate = f"{(1 - (cover_widths[i - 1] / (2 * d)))*100:.2f}%"
    cover_widths.append(W)
    overlap_rates.append(overlap_rate)

# 输出结果
print("位置（m）  覆盖宽度（m）  重叠率（%）")
for i in range(len(distances)):
    print(f"{distances[i]:6}     {cover_widths[i]:.2f}        {overlap_rates[i]}")
