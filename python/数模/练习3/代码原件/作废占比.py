import pandas as pd

# 读取Excel文件中的两个表格
file_path ="D:\Data\数模\练习3\附件2：302家无信贷记录企业的相关数据.xlsx"# 请替换为你的Excel文件路径
input_sheet_name = "进项发票信息"  # 请替换为进项发票信息表格的名称
output_sheet_name = "销项发票信息"  # 请替换为销项发票信息表格的名称
input_data = pd.read_excel(file_path, sheet_name=input_sheet_name, header=0)
output_data = pd.read_excel(file_path, sheet_name=output_sheet_name, header=0)

# 合并进项发票和销项发票信息
merged_data = pd.concat([input_data, output_data], ignore_index=True)

# 计算每家企业发票状态中作废发票的占比
company_invoice_counts = merged_data.groupby("企业代号")["发票状态"].count()
company_invalid_invoice_counts = merged_data[merged_data["发票状态"] == "作废发票"].groupby("企业代号")["发票状态"].count()

company_invalid_invoice_percentage = (company_invalid_invoice_counts / company_invoice_counts) * 100

# 创建结果DataFrame
result_df = pd.DataFrame({
    "企业代号": company_invalid_invoice_percentage.index,
    "作废发票占比(%)": company_invalid_invoice_percentage.values
})

# 将结果保存到Excel文件
output_result_file_path = "../数据输出/作废发票占比结果.xlsx"
result_df.to_excel(output_result_file_path, index=False)

print(f"结果已保存到文件: {output_result_file_path}")
