import pandas as pd
from datetime import datetime

# 读取进项发票信息
input_file_path = r"D:\Data\数模\练习3\进项发票信息.xlsx"  # 将路径替换为进项发票信息的Excel文件路径
input_sheet_name = "进项发票信息"  # 请替换为进项发票信息的表格名称
input_data = pd.read_excel(input_file_path, sheet_name=input_sheet_name, header=0)

input_data.columns = input_data.columns.str.strip()

# 读取销项发票信息
output_file_path = r"D:\Data\数模\练习3\销项发票信息.xlsx"  # 将路径替换为销项发票信息的Excel文件路径
output_sheet_name = "销项发票信息"  # 请替换为销项发票信息的表格名称
output_data = pd.read_excel(output_file_path, sheet_name=output_sheet_name, header=0)

output_data.columns = output_data.columns.str.strip()

# 筛选出"发票状态"不为"作废发票"的行
input_valid_invoice = input_data[input_data["发票状态"] != "作废发票"]
output_valid_invoice = output_data[output_data["发票状态"] != "作废发票"]

# 计算每个企业的总利润
profit_by_enterprise = (output_valid_invoice.groupby("企业代号")["金额"].sum() -
                        input_valid_invoice.groupby("企业代号")["价税合计"].sum())

# 计算每个企业的经营月数和月平均利润
monthly_avg_profit_by_enterprise = []
for enterprise_code in profit_by_enterprise.index:
    output_group = output_valid_invoice[output_valid_invoice["企业代号"] == enterprise_code]
    input_group = input_valid_invoice[input_valid_invoice["企业代号"] == enterprise_code]

    start_date = min(output_group["开票日期"].min(), input_group["开票日期"].min())
    end_date = max(output_group["开票日期"].max(), input_group["开票日期"].max())

    months = (end_date.year - start_date.year) * 12 + end_date.month - start_date.month + 1
    avg_profit = profit_by_enterprise[enterprise_code] / months
    monthly_avg_profit_by_enterprise.append({"企业编号": enterprise_code, "经营月数": months, "月平均利润": avg_profit})

# 创建结果DataFrame
result_df = pd.DataFrame(monthly_avg_profit_by_enterprise)

# 将结果保存到Excel文件
output_result_file_path = "../数据输出/月平均利润结果.xlsx"
result_df.to_excel(output_result_file_path, index=False)

print(f"结果已保存到文件: {output_result_file_path}")
