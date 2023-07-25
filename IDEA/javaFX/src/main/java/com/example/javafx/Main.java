package com.example.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            HBox root = new HBox();
            Button b1 = new Button("OK");
            Button b2 = new Button("cancel");
            root.getChildren().add(b2);
            root.getChildren().add(b1);

            OKHandlerClass handler1 = new OKHandlerClass();
            b1.setOnAction(handler1);

            Scene scene = new Scene(root,400,400);
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class OKHandlerClass implements EventHandler<ActionEvent> {
    public void handle(ActionEvent e) {
        System.out.println("OK button clicked");
    }
}