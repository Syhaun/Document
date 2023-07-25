package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ShowCircle extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle();
        Pane pane = new Pane(circle);
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(200);
        circle.setStroke(Color.BLUE);
        circle.setFill(Color.RED);


        Scene scene = new Scene(pane,1000,1000);
        primaryStage.setTitle("圆");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
