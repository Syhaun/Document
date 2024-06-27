def isHd(n):
    digits = list(str(n))
    max_num = int(''.join(sorted(digits, reverse=True)))
    min_num = int(''.join(sorted(digits)))
    return max_num - min_num == n