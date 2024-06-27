def isdif(n):
    digits = str(n)
    digit_set = set(digits)
    return len(digits) == len(digit_set)