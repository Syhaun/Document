s = input()
num = int(input())
if len(s) > num:
    new_s = s[:num]
else:
    new_s = s.ljust(num, '$')
print(new_s)