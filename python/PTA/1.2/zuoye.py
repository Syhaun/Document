import numpy as np

# 手动输入图中的数据
data = np.array([
    [93, 77, 75, 99],
    [63, 50, 88, 66],
    [99, 63, 81, 91],
    [94, 51, 57, 67],
    [89, 81, 76, 52],
    [95, 91, 64, 82],
    [72, 71, 78, 95],
    [86, 87, 87, 65],
    [86, 51, 63, 63],
    [68, 68, 78, 75],
    [77, 93, 91, 81],
    [62, 90, 66, 93],
    [85, 68, 86, 83],
    [62, 76, 81, 73],
    [75, 69, 53, 85]
])

# 计算每门课程的最高分、最低分、平均分和标准差
courses = ['Python语言', '数据结构', '操作系统', '软件工程']
statistics = {}

for i, course in enumerate(courses):
    highest = np.max(data[:, i])
    lowest = np.min(data[:, i])
    average = np.mean(data[:, i])
    std_dev = np.std(data[:, i])
    statistics[course] = {
        '最高分': highest,
        '最低分': lowest,
        '平均分': average,
        '标准差': std_dev
    }

# 输出结果
for course, stats in statistics.items():
    print(f"{course}:")
    print(f"  最高分: {stats['最高分']}")
    print(f"  最低分: {stats['最低分']}")
    print(f"  平均分: {stats['平均分']:.2f}")
    print(f"  标准差: {stats['标准差']:.2f}")
