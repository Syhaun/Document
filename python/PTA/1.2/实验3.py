def main():
    try:
        # 将字符串写入文件
        with open('documents/output.txt', 'w') as file:
            file.write("Python Program")

        # 查看文件的字节数
        with open('documents/output.txt', 'rb') as file:
            byte_count = len(file.read())
        print("文件的字节数为:", byte_count)

    except FileNotFoundError:
        print("文件路径错误，请检查文件路径是否正确。")
    except PermissionError:
        print("文件无法访问，请检查文件权限。")
    except Exception as e:
        print("发生错误:", e)


if __name__ == "__main__":
    main()
