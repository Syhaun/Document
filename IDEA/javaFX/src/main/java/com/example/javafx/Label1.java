package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Label1 extends Application {

    @Override
    public void start(Stage arg0) throws Exception {
        // TODO Auto-generated method stub
        ImageView china=new ImageView(new Image("D:\\Syhaun\\图片\\微信图片_20220930195952.jpg"));
        Label b1=new Label("China\n34 province",china);
        b1.setStyle("-fx-border-color:green;-fx-border-width:2");
        b1.setContentDisplay(ContentDisplay.BOTTOM);
        b1.setTextFill(Color.RED);
        HBox pane=new HBox(20);
        pane.getChildren().add(b1);
        Scene scene=new Scene(pane,450,150);
        arg0.setScene(scene);
        arg0.show();
    }

}