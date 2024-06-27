def change(money):
    if money[0] == '$':
        rmb = round(float(money[1:]) * 6.709, 2)
        print("{}美元 = {:.2f}人民币".format(money[1:], rmb))
    elif money[0] == '￥':
        usd = round(float(money[1:]) / 6.709, 2)
        print("{}人民币 = {:.2f}美元".format(money[1:], usd))