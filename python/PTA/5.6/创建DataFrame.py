import pandas as pd

# 从键盘输入学生的数量
n = int(input())

# 存储学生信息的列表
students = []

# 循环读取每个学生的信息
for _ in range(n):
    name, age = input().split()  # 输入格式为 "姓名 年龄"
    students.append([name, int(age)])

# 创建DataFrame对象
df = pd.DataFrame(students, columns=['姓名', '年龄'])

# 输出DataFrame
print(df)