package com.example.lightsfx;
import com.example.lightsfx.panel.myPanel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    myPanel panel = new myPanel();



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ding Application!");
        BorderPane root = new BorderPane();

       
        root.setCenter(panel.addHBox());

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

}


