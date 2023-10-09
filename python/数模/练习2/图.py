import matplotlib.pyplot as plt
import numpy as np
from scipy.interpolate import interp1d

plt.rcParams['font.sans-serif'] = ['SimHei']

# 数据
data = {
    "B1 50mgCo/SiO2-50mgHAP": [1.4, 3.4, 6.7, None, 19.3, 43.6],
    "B2 100mgCo/SiO2-100mgHAP": [2.8, 4.4, 6.2, None, 16.2, 45.1],
    "B3 10mgCo/SiO2-10mgHAP": [0.4, 0.6, 1.1, 3.3, 6.0, 21.1],
    "B4 25mgCo/SiO2-25mgHAP": [0.5, 1.1, 3.0, 6.1, 9.6, 33.5],
    "B6 75mgCo/SiO2-75mgHAP": [2.8, 7.5, 12.6, 15.9, 27.0, 63.2],
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
plt.title("乙醇转化率对比")
plt.xlabel("温度")
plt.ylabel("乙醇转化率(%)")
plt.legend()

# 显示图表
plt.show()
