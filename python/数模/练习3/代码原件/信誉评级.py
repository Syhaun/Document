import pandas as pd
import numpy as np
from sklearn.ensemble import RandomForestClassifier
from sklearn.preprocessing import LabelEncoder, OneHotEncoder
from sklearn.impute import SimpleImputer

# 读取有信誉评级的数据，即问题1中已有信誉评级的部分
known_data = pd.read_excel("D:\Data\数模\练习3\问题1.xlsx")

# 读取缺失信誉评级的数据，即问题2中缺失信誉评级的部分
unknown_data = pd.read_excel("D:\Data\数模\练习3\问题2.xlsx")

# 使用Label Encoder对信誉评级进行编码
label_encoder = LabelEncoder()
known_data['信誉评级'] = label_encoder.fit_transform(known_data['信誉评级'])

# 将训练集和测试集合并，以便一起进行特征处理
all_data = pd.concat([known_data, unknown_data], axis=0, ignore_index=True)

# 使用One-Hot Encoder对企业代号进行编码
all_data = pd.get_dummies(all_data, columns=['企业代号'], prefix=['企业代号'])

# 特征和标签
features = all_data.drop(['信誉评级'], axis=1)[:len(known_data)]
labels = all_data['信誉评级'][:len(known_data)]

# 创建插补器实例并填充缺失值
imputer = SimpleImputer(strategy='mean')
features = imputer.fit_transform(features)

# 初始化随机森林分类器
rf_classifier = RandomForestClassifier(n_estimators=100, random_state=42)

# 训练随机森林模型
rf_classifier.fit(features, labels)

# 对未知数据进行相同的特征处理
unknown_data_features = all_data.drop(['信誉评级'], axis=1)[len(known_data):]
unknown_data_features = imputer.transform(unknown_data_features)

# 使用训练好的模型进行插值，预测缺失信誉评级
predicted_ratings = rf_classifier.predict(unknown_data_features)

# 四舍五入预测结果到最近的整数
predicted_ratings_rounded = np.round(predicted_ratings).astype(int)

# 将插值结果添加回原数据框
unknown_data['信誉评级'] = label_encoder.inverse_transform(predicted_ratings_rounded)

# 将插值后的数据保存到文件中，或进行进一步分析
unknown_data.to_excel('问题2插值后的数据.xlsx', index=False)
