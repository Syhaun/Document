import vtk
# 创建 VTK 渲染器和交互器
aRenderer = vtk.vtkRenderer()
renWin = vtk.vtkRenderWindow()
renWin.AddRenderer(aRenderer)
iren = vtk.vtkRenderWindowInteractor()
iren.SetRenderWindow(renWin)

# 使用 vtkNIFTIImageReader 读取 NIfTI 格式的文件
v16 = vtk.vtkNIFTIImageReader()
v16.SetFileName("C:\\Users\\86130\\Desktop\\CT\\s0003\\ct.nii.gz")

skinExtractor = vtk.vtkContourFilter()
skinExtractor.SetInputConnection(v16.GetOutputPort())
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
outlineData.SetInputConnection(v16.GetOutputPort())

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
volumeMapper.SetInputConnection(v16.GetOutputPort())

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
iren.Start()
