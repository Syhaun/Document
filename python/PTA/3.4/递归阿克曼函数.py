ak = {}


def akm(m, n):
    if (m, n) in ak:
        return ak[(m, n)]
    elif m == 0:
        result = n + 1
    elif m > 0 and n == 0:
        result = akm(m - 1, 1)
    elif m > 0 and n > 0:
        result = akm(m - 1, akm(m, n - 1))

    ak[(m, n)] = result
    return result