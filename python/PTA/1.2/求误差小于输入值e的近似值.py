import math

error = float(input())
e = 1.0
i = 1
fac = 1
while True:
    temp = 1 / fac
    e_pre = e
    e += temp
    if abs(e_pre - e) < error:
        break
    i += 1
    fac *=i
print(round(e, 6))