def fn(a, n):
    sum = 0
    while n:
        sum += 通项公式(a,n)
        n -= 1
    return sum
def 通项公式(a , n):
    sum = 0
    while n:
        sum += a*10**(n-1)
        n-=1
    return sum