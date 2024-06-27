import pandas as pd
n = int(input())
records = []
for _ in range(n):
    record = input().strip().split()
    date = record[0]
    sales = int(record[1])
    records.append((date, sales))

# 创建DataFrame
df = pd.DataFrame(records, columns=['日期', '销售额'])

# 将日期列转换为日期时间类型
df['日期'] = pd.to_datetime(df['日期'])

# 提取年月信息，添加新列
df['年月'] = df['日期'].dt.to_period('M')

# 计算每个月的销售总额
monthly_sales = df.groupby('年月')['销售额'].sum().reset_index()

# 将年月列转换为字符串格式
monthly_sales['年月'] = monthly_sales['年月'].astype(str)

# 重命名列
monthly_sales.columns = ['月份', '销售额']

# 按月份排序
monthly_sales = monthly_sales.sort_values(by='月份')

# 输出结果
print(monthly_sales)