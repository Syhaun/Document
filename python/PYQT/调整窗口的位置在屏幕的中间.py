import sys

from PyQt5.QtWidgets import QApplication, QWidget, QPushButton, QDesktopWidget

if __name__ == '__main__':
    app = QApplication(sys.argv)
    w = QWidget()

    # 设置窗口标题

    w.setWindowTitle("第一个按钮")

    # 窗口的大小
    w.resize(300, 300)

    # 将窗口设置在屏幕的左上角

    w.move(0, 0)

    # 调整窗口在屏幕中央显示

    center_pointer = QDesktopWidget().availableGeometry().center()
    x = center_pointer.x()
    y = center_pointer.y()
    old_x, old_y, width, height = w.frameGeometry().getRect()
    w.move(x - width / 2, y - height / 2)

    # 展示窗口

    w.show()
    app.exec_()
