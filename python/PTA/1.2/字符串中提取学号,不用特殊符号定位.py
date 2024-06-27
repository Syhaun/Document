import re

def student_id(string):
    match = re.search(r'\d{1,2}', string)
    if match:
        student_id = match.group(0)
        if student_id == '00'or student_id == '0':
            return "not find"
        else:
            return int(student_id)
    else:
        return "not find"
string = input()
print(student_id(string))
