import sys

from PyQt5.QtWidgets import QWidget, QApplication, QVBoxLayout, QPushButton, QGroupBox, QRadioButton, QHBoxLayout


class MyWindow(QWidget):
    def __init__(self):
        # 切记一定要调用父类的__init__方法, 因为它里面有很多对UI空间的初始化操作
        super().__init__()
        self.init_ui()

    def init_ui(self):
        # 最外层的垂直布局, 包换两部分: 爱好和性别
        container = QVBoxLayout()

        hobby_box = QGroupBox("爱好")
        # v_layout 保证三个爱好是垂直摆放
        v_layout = QVBoxLayout()
        btn1 = QRadioButton("抽烟")
        btn2 = QRadioButton("喝酒")
        btn3 = QRadioButton("烫头")
        # 添加到V_layout中
        v_layout.addWidget(btn1)
        v_layout.addWidget(btn2)
        v_layout.addWidget(btn3)
        # 将v_layout添加到hobby_box中
        hobby_box.setLayout(v_layout)

        gender_box = QGroupBox("性别")
        # 性别容器
        h_layout = QHBoxLayout()
        # 性别选项
        butn4 = QRadioButton("男")
        butn5 = QRadioButton("女")
        # 追加到性别容器中
        h_layout.addWidget(butn4)
        h_layout.addWidget(butn5)
        # 添加到 box中
        gender_box.setLayout(h_layout)

        # 把爱好和性别添加到容器中
        container.addWidget(hobby_box)
        container.addWidget(gender_box)

        # 设置窗口显示的内容是最外层容器
        self.setLayout(container)


if __name__ == '__main__':
    app = QApplication(sys.argv)

    # 创建一个QWideget儿类
    w = MyWindow()
    w.show()

    app.exec_()
