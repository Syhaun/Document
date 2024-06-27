import pandas as pd
n,m = input().split(' ')
A = []
B = []
for i in range(int(n)):
    col1,col2 = input().split(' ')
    A.append({'列1':col1,'列2':col2})
df1 = pd.DataFrame(A)
for i in range(int(m)):
    col1,col2 = input().split(' ')
    B.append({'列1':col1,'列2':col2})
df2= pd.DataFrame(B)
print('数据合并结果：')
df = df1._append(df2,ignore_index=True)
print(df)

result = pd.concat([df1, df2], axis=1)
print('数据连接结果：')
print(result)