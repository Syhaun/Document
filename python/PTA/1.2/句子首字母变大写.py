import re
sentence = input()
output = ""
sentences = re.split("([?.!])", sentence)
sentences = ["".join(i) for i in zip(sentences[0::2],sentences[1::2])]
print(sentences)
for sentence in sentences:
    output += sentence.capitalize()


print(output)

