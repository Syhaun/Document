def digitSum(n):
    digitS = str(n)
    sum = 0
    for digit in digitS:
        sum += int(digit)
    return sum
