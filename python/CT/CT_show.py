import sys
import nibabel as nib
import vtk
from PyQt5.QtCore import Qt
from PyQt5.QtGui import QPixmap, QIcon
from PyQt5.QtWidgets import QApplication, QWidget, QVBoxLayout, QHBoxLayout, QLabel, QPushButton, QFileDialog, QFrame
from vtkmodules.qt.QVTKRenderWindowInteractor import QVTKRenderWindowInteractor
from vtkmodules.util import numpy_support
from vtkmodules.vtkFiltersGeometry import vtkGeometryFilter


class MainWindow(QWidget):
    def __init__(self):
        super().__init__()
        self.frame = QFrame()

        self.vtkWidget = QVTKRenderWindowInteractor(self.frame)

        left_layout = QVBoxLayout()

        self.image1_label = QLabel()
        self.image1_label.setAlignment(Qt.AlignCenter)

        images_layout = QHBoxLayout()
        images_layout.addWidget(self.image1_label)
        images_layout.addWidget(self.vtkWidget)

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

        # self.ren = vtk.vtkRenderer()
        # self.vtkWidget.GetRenderWindow().AddRenderer(self.ren)
        # self.iren = self.vtkWidget.GetRenderWindow().GetInteractor()
        #


        self.setLayout(main_layout)

    def load_ct_data(self):
        file_path, _ = QFileDialog.getOpenFileName(self, "选择CT数据文件", "", "NIfTI Files (*.nii *.nii.gz)")
        if file_path:
            ct_data = nib.load(file_path)
            image_data = ct_data.get_fdata()
            vtk_data = numpy_support.numpy_to_vtk(image_data.ravel(), 1, vtk.VTK_SHORT)
            print(1)
            # 创建 VTK 渲染器和交互器
            aRenderer = vtk.vtkRenderer()
            renWin = vtk.vtkRenderWindow()
            renWin.AddRenderer(aRenderer)
            iren = vtk.vtkRenderWindowInteractor()
            iren.SetRenderWindow(renWin)
            print(2)

            # 创建 VTK 数据
            vtk_image_data = vtk.vtkImageData()
            print(3)
            vtk_image_data.SetDimensions(image_data.shape[::-1])  # 设置图像数据的维度
            print(4)
            spacing = (0.1, 0.1, 0.1)
            vtk_image_data.SetSpacing(spacing)  # 设置图像数据的间距
            origin = (0.0, 0.0, 0.0)
            vtk_image_data.SetOrigin(origin)  # 设置图像数据的原点
            vtk_image_data.GetPointData().SetScalars(vtk_data)

            print(5)
            # 使用 vtkGeometryFilter 将 vtkImageData 转换为 vtkPolyData
            geometry_filter = vtkGeometryFilter()
            geometry_filter.SetInputData(vtk_image_data)
            geometry_filter.Update()

            vtk_poly_data = geometry_filter.GetOutput()

            skinExtractor = vtk.vtkContourFilter()
            skinExtractor.SetInputConnection(vtk_poly_data)
            skinExtractor.SetValue(0, 500)

            skinNormals = vtk.vtkPolyDataNormals()
            skinNormals.SetInputConnection(skinExtractor.GetOutputPort())
            skinNormals.SetFeatureAngle(60.0)

            # 使用 vtkPolyDataMapper 替代 vtkImageDataGeometryFilter
            skinMapper = vtk.vtkPolyDataMapper()
            skinMapper.SetInputConnection(skinNormals.GetOutputPort())
            skinMapper.ScalarVisibilityOff()

            # 使用 vtkActor 替代 vtkImageActor
            skin = vtk.vtkActor()
            skin.SetMapper(skinMapper)

            outlineData = vtk.vtkOutlineFilter()
            outlineData.SetInputConnection(vtk_image_data)

            mapOutline = vtk.vtkPolyDataMapper()
            mapOutline.SetInputConnection(outlineData.GetOutputPort())

            outline = vtk.vtkActor()
            outline.SetMapper(mapOutline)
            outline.GetProperty().SetColor(0, 0, 0)

            aCamera = vtk.vtkCamera()
            aCamera.SetViewUp(0, 0, -1)
            aCamera.SetPosition(0, 1, 0)
            aCamera.SetFocalPoint(0, 0, 0)
            aCamera.ComputeViewPlaneNormal()

            # 使用 vtkVolume 和 vtkFixedPointVolumeRayCastMapper 创建体绘制效果
            volumeMapper = vtk.vtkFixedPointVolumeRayCastMapper()
            volumeMapper.SetInputConnection(vtk_image_data)

            # 调整 vtkVolumeProperty 设置
            volumeProperty = vtk.vtkVolumeProperty()
            volumeProperty.ShadeOn()
            volumeProperty.SetInterpolationTypeToLinear()

            # 设置颜色映射
            colorFunc = vtk.vtkColorTransferFunction()
            colorFunc.AddRGBPoint(0, 0.0, 0.0, 0.0)
            colorFunc.AddRGBPoint(500, 1.0, 1.0, 1.0)

            # 设置不透明度映射，将黑色部分调成透明
            opacityFunc = vtk.vtkPiecewiseFunction()
            opacityFunc.AddPoint(0, 0.0)
            opacityFunc.AddPoint(500, 1.0)

            volumeProperty.SetColor(colorFunc)
            volumeProperty.SetScalarOpacity(opacityFunc)

            # 添加体绘制部分
            volume = vtk.vtkVolume()
            volume.SetMapper(volumeMapper)
            volume.SetProperty(volumeProperty)

            aRenderer.AddActor(outline)
            aRenderer.AddActor(skin)
            aRenderer.AddVolume(volume)

            aRenderer.SetActiveCamera(aCamera)
            aRenderer.ResetCamera()
            aCamera.Dolly(1.5)

            aRenderer.SetBackground(1, 1, 1)
            renWin.SetSize(640, 480)
            aRenderer.ResetCameraClippingRange()

            iren.Initialize()



if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = MainWindow()
    window.setWindowTitle("CT影像处理")
    window.setWindowIcon(QIcon('img_2.png'))
    window.resize(1000, 1000)
    window.show()
    sys.exit(app.exec_())
