package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonInpane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.getChildren().add(new Button("65656565"));//相当于StackPane pane = new StackPane(new Button("6565665656"));
        Scene scene = new Scene(pane,1500,1000);
        primaryStage.setTitle("按钮在窗口上");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
