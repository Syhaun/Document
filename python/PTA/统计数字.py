T = int(input())
for i in range(T):
    count = 0
    age = input()
    for letter in age:
        if letter.isdigit():
            count+=1
    print(count)