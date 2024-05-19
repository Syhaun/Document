n = int(input())
for i in range(n):
    if i % 3 == 2 and i % 5 == 3 and i % 7 == 2:
        print(f"{i} ",end='')
if n < 23:
    print("没有")