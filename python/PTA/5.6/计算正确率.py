def calculate_accuracy(list1, list2):
    total_count = len(list1)
    correct_count = sum(1 for x, y in zip(list1, list2) if x == y)
    accuracy = (correct_count / total_count) * 100
    return int(accuracy)

list1 = eval(input().strip())
list2 = eval(input().strip())

accuracy = calculate_accuracy(list1, list2)
print(f"{accuracy}%")
