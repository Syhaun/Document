target = int(input())
i = 1
sum = 0
while True:
    sum += i
    if sum >= target:
        break
    i += 1
print(f"{sum}=1+2+...+{i}")