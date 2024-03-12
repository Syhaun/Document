import sys

from PyQt5.QtWidgets import QApplication, QWidget, QPushButton, QLabel

if __name__ == '__main__':
    app = QApplication(sys.argv)
    w = QWidget()

    # 设置窗口标题

    w.setWindowTitle("第一个文本")

    # 下面创建一个Label,在创建的时候指定的父对象
    label = QLabel("账号:", w)

    # 显示位置与大小:x,y,w,h
    label.setGeometry(20, 20, 30, 30)

    # 展示窗口

    w.show()
    app.exec_()
