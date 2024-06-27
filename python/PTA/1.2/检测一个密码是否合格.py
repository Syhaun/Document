password = input()


def check(password):
    if len(password) < 8:
        return False
    小写字母 = False
    大写字母 = False
    数字 = False
    其他字符 = False
    for i in password:
        if i.islower():
            小写字母 = True
        elif i.isupper():
            大写字母 = True
        elif i.isdigit():
            数字 = True
        else:
            其他字符 = True
    return 小写字母 and 大写字母 and 数字 and 其他字符


if check(password):
    print("valid password")
else:
    print("invalid password")
