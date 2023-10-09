import pandas as pd
from datetime import datetime

# 读取Excel文件中的第二张表格
file_path = r"D:\Data\数模\练习3\附件2 - 副本.xlsx"# 将路径替换为你的Excel文件路径
sheet_name = "进项发票信息"  # 请替换为你的表格名称
data = pd.read_excel(file_path, sheet_name=sheet_name, header=0)

data.columns = data.columns.str.strip()

# 筛选出"发票状态"不为"作废发票"的行
data_valid_invoice = data[data["发票状态"] != "作废发票"]

# 计算每个企业的总利润
profit_by_enterprise = data_valid_invoice.groupby("企业代号")["金额"].sum()

# 计算每个企业的经营月数和月平均利润
monthly_avg_profit_by_enterprise = []
for enterprise_code, group in data_valid_invoice.groupby("企业代号"):
    start_date = group["开票日期"].min()
    end_date = group["开票日期"].max()
    months = (end_date.year - start_date.year) * 12 + end_date.month - start_date.month + 1
    avg_profit = profit_by_enterprise[enterprise_code] / months
    monthly_avg_profit_by_enterprise.append({"企业编号": enterprise_code, "经营月数": months, "月平均利润": avg_profit})

# 创建结果DataFrame
result_df = pd.DataFrame(monthly_avg_profit_by_enterprise)

# 将结果保存到Excel文件
output_file_path = "../数据输出/进项价税合计.xlsx"
result_df.to_excel(output_file_path, index=False)

print(f"结果已保存到文件: {output_file_path}")
