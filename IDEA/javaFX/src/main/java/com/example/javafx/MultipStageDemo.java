package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MultipStageDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Button("OK"),500,500);
        primaryStage.setTitle("张超顶呱呱");
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage stage = new Stage();
        stage.setTitle("小谢顶呱呱");
        stage.setScene(new Scene(new Button("嗨嗨嗨"),500,500));
        stage.show();
    }
}
