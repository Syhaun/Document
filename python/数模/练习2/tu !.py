import matplotlib.pyplot as plt
import numpy as np
from scipy.interpolate import interp1d

plt.rcParams['font.sans-serif'] = ['SimHei']

# 数据
data = {
    "B1 50mgCo/SiO2-50mgHAP": [6.32, 8.25, 12.28, None, 25.97, 41.08],
    "B2 100mgCo/SiO2-100mgHAP": [3.26, 4.97, 9.32, None, 22.88, 38.7],
    "B3 10mgCo/SiO2-10mgHAP": [2.85, 5.35, 7.61, 7.74, 13.81, 21.21],
    "B4 25mgCo/SiO2-25mgHAP": [6.62, 6.62, 5.05, 8.33, 13.1, 21.45],
    "B6 75mgCo/SiO2-75mgHAP": [4.5, 4.79, 8.77, 16.06, 22.41, 30.48],
}

temperatures = [250, 275, 300, 325, 350, 400]

# 绘制折线图
for catalyst, selectivity in data.items():
    if None in selectivity:
        indexes = np.where(np.array(selectivity) != None)[0]
        f = interp1d(np.array(temperatures)[indexes], np.array(selectivity)[indexes], kind='linear', fill_value='extrapolate')
        selectivity = [f(temp) if value is None else value for temp, value in zip(temperatures, selectivity)]

    plt.plot(temperatures, selectivity, label=catalyst)
    plt.scatter(temperatures, selectivity)  # 添加数据点

# 添加标题和标签
plt.title("C4选择率对比")
plt.xlabel("温度")
plt.ylabel("C4选择率(%)")
plt.legend()

# 显示图表
plt.show()
