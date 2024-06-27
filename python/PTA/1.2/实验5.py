import os

def list_files_and_directories(path):
    # 获取当前目录下的文件和目录
    content = os.listdir(path)
    for item in content:
        full_path = os.path.join(path, item)
        if os.path.isdir(full_path):
            print("目录:", full_path)
            # 递归调用自身来处理子目录
            list_files_and_directories(full_path)
        else:
            print("文件:", full_path)

def main():
    current_directory = os.getcwd()
    print("当前目录:", current_directory)
    list_files_and_directories(current_directory)

if __name__ == "__main__":
    main()
