import pandas as pd

# 从键盘输入销售记录的数量
n = int(input())

# 存储销售记录的列表
sales = []

# 循环读取每条销售记录
for _ in range(n):
    product, amount, quantity = input().split()  # 输入格式为 "产品名称 销售额 销售数量"
    sales.append([product, int(amount), int(quantity)])

# 创建DataFrame对象
df = pd.DataFrame(sales, columns=['产品名称', '销售额', '销售数量'])

# 按产品名称分组，计算销售额和销售数量的总和
grouped_df = df.groupby('产品名称').agg({'销售额': 'sum', '销售数量': 'sum'}).reset_index()

# 输出结果
print(grouped_df)