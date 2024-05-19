def main():
    try:
        user_input = input("请输入一行字符：")
        result = user_input.lower()
        with open('documents/output.txt', 'w') as file:
            file.write(result)
        print("转换后的结果已保存到文件 output.txt 中。")
    except FileNotFoundError:
        print("文件路径错误，请检查文件路径是否正确。")
    except PermissionError:
        print("文件无法访问，请检查文件权限。")
    except Exception as e:
        print("发生错误:", e)

if __name__ == "__main__":
    main()
