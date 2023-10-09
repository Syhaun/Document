import pandas as pd

# 读取Excel文件中的第二张表格
file_path = r"D:\Data\数模\练习3\销项发票信息.xlsx" # 将路径替换为你的Excel文件路径
sheet_name = "销项发票信息"  # 请替换为你的表格名称
data = pd.read_excel(file_path, sheet_name=sheet_name, header=0)

data.columns = data.columns.str.strip()

# 删除发票单号重复的行，只保留唯一的行
data_unique_invoice = data.drop_duplicates(subset=["发票号码"], keep="first")

# 将删除重复行后的数据覆盖原始文件
data_unique_invoice.to_excel(file_path, sheet_name=sheet_name, index=False)
