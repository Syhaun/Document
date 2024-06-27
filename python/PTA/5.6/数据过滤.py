import pandas as pd

# 从键盘输入学生的数量
n = int(input())

# 存储学生信息的列表
students = []

# 循环读取每个学生的信息
for _ in range(n):
    name, age, score = input().split()  # 输入格式为 "姓名 年龄 成绩"
    students.append([name, int(age), int(score)])

# 创建DataFrame对象
df = pd.DataFrame(students, columns=['姓名', '年龄', '成绩'])

# 从键盘输入成绩阈值
threshold = int(input())

# 根据成绩阈值过滤数据
filtered_df = df[df['成绩'] >= threshold]

# 输出满足条件的学生信息
print(filtered_df)