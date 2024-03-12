import sys

from PyQt5.QtWidgets import QWidget, QApplication, QVBoxLayout, QPushButton


class MyWindow(QWidget):
    def __init__(self):
        # 切记一定要调用父类的__init__方法, 因为它里面有很多对UI空间的初始化操作
        super().__init__()

    #         设置大小
        self.resize(300, 300)
#         设置标题
        self.setWindowTitle("垂直布局")
#         垂直布局
        layout = QVBoxLayout()

#         作用是在布局器中增加一个伸缩量,里面的参数表示QSpacerItem的个数,默认值为零
#           会将你放在layout中的空间压缩成默认的大小
#           下面的笔试1: 1: 1: 2
#           layout.addStretch(1)
        #按钮1
        but1 = QPushButton("按钮1")
        layout.addWidget(but1)
        # 按钮2
        but2 = QPushButton("按钮2")
        layout.addWidget(but2)
        # 按钮3
        but3 = QPushButton("按钮3")
        layout.addWidget(but3)
        # 添加一个伸缩器
        layout.addStretch()

        self.setLayout(layout)


if __name__ == '__main__':
    app = QApplication(sys.argv)

# 创建一个QWideget儿类
    w = MyWindow()
    w.show()

    app.exec_()