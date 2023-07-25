package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LabelWithGraphic extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ImageView us = new ImageView(new Image("D:\\Syhaun\\图片\\微信图片_20220930195952.jpg"));
        Label lbl = new Label("无敌是多么寂寞",us);
        lbl.setContentDisplay(ContentDisplay.BOTTOM);

        Label lb2 = new Label("Circle",new Circle(50,50,24));
        lb2.setContentDisplay(ContentDisplay.TOP);
        lb2.setTextFill(Color.ORANGE);

        Label lb3 = new Label("Rectangle",new Rectangle(10,10,50,25));
        lb3.setContentDisplay(ContentDisplay.LEFT);

        Label lb4 = new Label("Ellipse",new Ellipse(50,50,50,25));
        lb4.setContentDisplay(ContentDisplay.RIGHT);

        Ellipse ellipse = new Ellipse(50,50,50,25);
        ellipse.setStroke(Color.GREEN);
        ellipse.setFill(Color.WHITE);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(ellipse,new Label("JavaFX"));
        Label lb5 = new Label("A pane inside a label1",stackPane);
        lb5.setContentDisplay(ContentDisplay.BOTTOM);

        HBox pane = new HBox(20);
        pane.getChildren().addAll(lbl,lb2,lb3,lb4,lb5);

        Scene scene = new Scene(pane,450,150);
        primaryStage.setTitle("haihahia");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
