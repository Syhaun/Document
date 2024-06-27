def isNum(x):
    try:
        complex(x)
        return True
    except ValueError:
        return False