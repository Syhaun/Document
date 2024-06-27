import pickle

def save_to_binary_file(data, filename):
    try:
        with open(filename, 'wb') as file:
            pickle.dump(data, file)
        print("数据已成功保存到二进制文件:", filename)
    except Exception as e:
        print("保存文件时出现错误:", e)

def read_binary_file(filename):
    try:
        with open(filename, 'rb') as file:
            data = pickle.load(file)
            return data
    except Exception as e:
        print("读取文件时出现错误:", e)

def main():
    # 学生成绩字典
    student_grades = {
        "Alice": 85,
        "Bob": 72,
        "Charlie": 90,
        "David": 78,
        "Eve": 94
    }

    # 保存成绩到二进制文件
    save_to_binary_file(student_grades, 'documents/student_grades.dat')

    # 从二进制文件读取数据并显示
    loaded_data = read_binary_file('documents/student_grades.dat')
    if loaded_data:
        print("从二进制文件中读取的数据:")
        for name, score in loaded_data.items():
            print(f"{name}: {score}")

if __name__ == "__main__":
    main()
