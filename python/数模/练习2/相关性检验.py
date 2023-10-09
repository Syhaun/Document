import scipy.stats as stats

# 按照您的数据结构创建两组数据
data_b1 = [1.4, 3.4, 6.7, 19.3, 43.6]
data_a12 = [1.4, 3.5, 6.9, 19.9, 44.5]

# 执行Mann-Whitney U检验
statistic, p_value = stats.mannwhitneyu(data_b1, data_a12, alternative='two-sided')

# 输出检验结果
print("Mann-Whitney U统计量:", statistic)
print("p值:", p_value)

# 根据显著性水平判断结果
alpha = 0.05
if p_value < alpha:
    print("拒绝零假设，存在差异")
else:
    print("无法拒绝零假设，差异不显著")
