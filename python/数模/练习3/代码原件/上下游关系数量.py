import pandas as pd

# 读取销项发票信息
file_path = "D:\Data\数模\练习3\进项发票信息.xlsx"  # 请替换为您的文件路径
sheet_name = "进项发票信息"  # 请替换为您的表格名称
data = pd.read_excel(file_path, sheet_name=sheet_name, header=0)

# 根据企业代号进行分组，统计每个企业的购方单位代号的种类数量
company_customer_count = data.groupby("企业代号")["销方单位代号"].nunique().reset_index()
company_customer_count.rename(columns={"购方单位代号": "购方单位种类数量"}, inplace=True)

# 将结果保存到Excel文件
output_file_path = "../数据输出/企业上游合作关系.xlsx"
company_customer_count.to_excel(output_file_path, index=False)

print(f"结果已保存到文件: {output_file_path}")
