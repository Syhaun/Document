code = ['BABA', 'FB', 'JD', 'BABA', 'JD', 'FB']
price = [[170, 177, 169], [150, 159, 153], [24, 27, 26], [165, 170, 167], [22, 23, 20], [155, 161, 157]]

# 输入企业代码
enterprise_code = input().strip()

# 获取该企业的价格
index = [i for i, c in enumerate(code) if c == enterprise_code]
if len(index) > 0:
    prices = [price[i][1] for i in index]
    highest_price = max(prices)
    prices.remove(highest_price)
    second_highest_price = max(prices)
    output = "[" + str(highest_price) + " " + str(second_highest_price) + "]"
    print(output)