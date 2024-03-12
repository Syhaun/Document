import sys

import nibabel as nib
import vtk
from PyQt5.QtCore import Qt
from PyQt5.QtGui import QPixmap, QIcon
from PyQt5.QtWidgets import QApplication, QWidget, QVBoxLayout, QHBoxLayout, QLabel, QPushButton, QFileDialog
from matplotlib import pyplot as plt


class MainWindow(QWidget):
    def __init__(self):
        super().__init__()
        left_layout = QVBoxLayout()

        self.image1_label = QLabel()
        self.image1_label.setAlignment(Qt.AlignCenter)
        # image1_label.setPixmap(QPixmap("ct.png"))

        image2_label = QLabel()
        image2_label.setAlignment(Qt.AlignCenter)
        image2_label.setPixmap(QPixmap("img_1.png"))

        images_layout = QHBoxLayout()
        images_layout.addWidget(self.image1_label)
        images_layout.addWidget(image2_label)

        display_label = QLabel("这是一个显示框")
        display_label.setAlignment(Qt.AlignCenter)

        left_layout.addLayout(images_layout)
        left_layout.addWidget(display_label)

        right_layout = QVBoxLayout()

        button1 = QPushButton("加载")
        button2 = QPushButton("处理")
        button3 = QPushButton("没想好有啥用的按钮")

        button1.clicked.connect(self.load_ct_data)

        right_layout.addWidget(button1)
        right_layout.addWidget(button2)
        right_layout.addWidget(button3)

        main_layout = QHBoxLayout()
        main_layout.addLayout(left_layout, 8)
        main_layout.addLayout(right_layout, 2)

        self.setLayout(main_layout)

    def load_ct_data(self):
        file_path, _ = QFileDialog.getOpenFileName(self, "选择CT数据文件", "", "NIfTI Files (*.nii *.nii.gz)")
        # print(file_path)
        # file_path = 'C:\\Users\\86130\\Desktop\\CT\\s0003\\ct.nii.gz'
        if file_path:
            ct_data = nib.load(file_path)
            # # self.display_label.setText(f"已加载 CT 数据：{file_path}")
            ct_data_array = ct_data.get_fdata()
            # # 创建可视化窗口和渲染器
            # renderer = vtk.vtkRenderer()
            # renderWindow = vtk.vtkRenderWindow()
            # renderWindow.AddRenderer(renderer)
            #
            # # 创建交互器并将其与渲染窗口关联
            # interactor = vtk.vtkRenderWindowInteractor()
            # interactor.SetRenderWindow(renderWindow)
            #
            # # 创建体绘制器并将其添加到渲染器中
            # volumeMapper = vtk.vtkSmartVolumeMapper()
            # volumeMapper.SetInputConnection(image_data.GetOutputPort())
            # volumeProperty = vtk.vtkVolumeProperty()
            # volume = vtk.vtkVolume()
            # volume.SetMapper(volumeMapper)
            # volume.SetProperty(volumeProperty)
            # renderer.AddVolume(volume)
            #
            # # 设置背景颜色和窗口大小
            # renderer.SetBackground(0, 0, 0)
            # renderWindow.SetSize(800, 800)
            #
            # # 启动交互器
            # interactor.Initialize()
            # renderWindow.Render()
            # interactor.Start()
            central_slice = ct_data_array[:, :, ct_data_array.shape[2] // 2]
            plt.imshow(central_slice, cmap='gray')
            plt.savefig('ct.png')
            self.image1_label.setPixmap(QPixmap("ct.png"))


if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = MainWindow()
    window.setWindowTitle("CT影像处理")
    window.setWindowIcon(QIcon('img_2.png'))
    window.resize(1000,1000)
    window.show()
    sys.exit(app.exec_())
