package com.example.javafx;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main1 extends Application {
    static int s=0;
    @Override
    public void start(Stage stage) {
        Button button = new Button();
        ImageView imageView = new ImageView(new Image("D:\\Syhaun\\图片\\微信图片_20230530201203.png"));
        button.setGraphic(imageView);

        Text text = new Text("功德+0");
        text.setFont(new Font(20));

// 创建一个时间轴对象
        Timeline timeline = new Timeline();

// 创建一个键值对象，指定图像视图的初始图像和结束图像

        KeyValue keyValue2 = new KeyValue(imageView.imageProperty(), new Image("D:\\Syhaun\\图片\\微信图片_20230530201203.png"));
        KeyValue keyValue1 = new KeyValue(imageView.imageProperty(), new Image("D:\\Syhaun\\图片\\微信图片_20230530201220.png"));

// 创建两个关键帧对象，分别指定图像视图更改的持续时间和键值对象
        KeyFrame keyFrame1 = new KeyFrame(Duration.millis(0.1), keyValue1);
        KeyFrame keyFrame2 = new KeyFrame(Duration.millis(100), keyValue2);
// 将关键帧对象添加到时间轴中
        timeline.getKeyFrames().addAll(keyFrame1, keyFrame2);
        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(button, text);
        vbox.setAlignment(Pos.CENTER);

        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(vbox);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20));

        StackPane root = new StackPane();
        root.getChildren().add(vbox);

        button.setOnAction(event -> {
            timeline.play();
            Main1.s++;
            text.setText("功德+" + Main1.s);
        });

        Scene scene = new Scene(root, 540, 540);
        stage.setTitle("Button Animation Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}