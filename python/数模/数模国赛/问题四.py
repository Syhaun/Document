import pandas as pd
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D  # 导入绘制三维图所需的子模块

# 读取数据文件
data = pd.read_excel('C:/Users/86130/Desktop/数模国赛/B题/附件.xlsx')

# 提取横向坐标、纵向坐标和海水深度数据
x = data['横向坐标/NM（由西向东）']  # 从西向东的横向坐标
y = data['纵向坐标/NM（由南向北）']  # 从南向北的纵向坐标
depth = data['海水深度/m']

# 创建三维图
fig = plt.figure(figsize=(10, 6))
ax = fig.add_subplot(111, projection='3d')

# 绘制三维散点图
ax.scatter(x, y, depth, c=depth, cmap='viridis', marker='s')

# 设置轴标签
ax.set_xlabel('横向坐标/NM（由西向东）')
ax.set_ylabel('纵向坐标/NM（由南向北）')
ax.set_zlabel('海水深度/m')

# 设置标题
ax.set_title('三维海水深度分布图')

# 显示图像
plt.show()
