def f(n, x, *a):
    result = 0
    for i in range(n+1):
        result += a[i] * (x ** i)
    return result