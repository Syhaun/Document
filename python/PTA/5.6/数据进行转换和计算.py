import pandas as pd

# 从键盘输入销售记录的数量
n = int(input())

# 存储销售记录的列表
sales = []

# 循环读取每条销售记录
for _ in range(n):
    dish, price, quantity = input().split()  # 输入格式为 "菜品名称 单价 销量"
    sales.append([dish, float(price), int(quantity)])

# 创建DataFrame对象
df = pd.DataFrame(sales, columns=['菜品名称', '单价', '销量'])

# 计算销售额（单价 * 销量）
df['销售额'] = df['单价'] * df['销量']

# 计算销售额占总销售额的百分比
df['销售占比'] = df['销售额'] / df['销售额'].sum() * 100

# 按销售额降序排列
df = df.sort_values(by='销售额', ascending=False).reset_index(drop=True)

# 输出结果
print(df)