n = int(input())
numbers = input().split()

max_value = 0
max_index = 0

for i in range(n):
    a = int(numbers[i])
    if a > max_value:
        max_value = a
        max_index = i

print(max_value,  max_index)
