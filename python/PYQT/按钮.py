import sys

from PyQt5.QtWidgets import QApplication, QWidget, QPushButton

if __name__ == '__main__':
    app = QApplication(sys.argv)
    w = QWidget()

    # 设置窗口标题

    w.setWindowTitle("第一个按钮")
    btn = QPushButton("按钮")

    # 设置按钮的父亲是当前的窗口,等于是添加到窗口中显示
    btn.setParent(w)

    #展示窗口
    w.show()
    app.exec_()