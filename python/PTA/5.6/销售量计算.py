# 假设输入是以空格分隔的字符串形式给出的
input_str = input()
sales_cumulative = list(map(float, input_str.split()))  # 将输入字符串转换为浮点数列表

# 初始化一个列表来保存每月的销售额
monthly_sales = []

# 计算2-6月的销售额
for i in range(1, len(sales_cumulative)):
    monthly_sales.append(sales_cumulative[i] - sales_cumulative[i-1])

# 格式化输出，注意保留一位小数
formatted_sales = ["{:.1f}".format(sale) for sale in monthly_sales]

# 输出结果
print(f"2-6月各月销量为： [{', '.join(formatted_sales)}]")