def main():
    try:
        # 读取文件内容
        with open('documents/input.txt', 'r') as file:
            content = file.read()

        # 将大写字母转换为小写字母
        result = content.lower()

        # 将结果写回文件
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
