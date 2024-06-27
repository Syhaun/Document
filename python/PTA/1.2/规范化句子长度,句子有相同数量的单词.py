s = input()
num = int(input())
words = s.split()
if len(words) > num:
    new_s = ' '.join(words[:num])
else:
    word = ['PAD'] * (num - len(words))
    new_s = ' '.join(words + word)
print(new_s)
