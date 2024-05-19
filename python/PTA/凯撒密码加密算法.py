text = input()
key = int(input())
result = ""
for char in text:
    if char.isalpha():
        if char.islower():
            result += chr((ord(char) - ord('a') + key) % 26 + ord('a'))
        else:
            result += chr((ord(char) - ord('A') + key) % 26 + ord('A'))
    else:
        result += char
print(result)