package com.example.lightsfx;
import com.example.lightsfx.panel.MyPanel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LightsFx extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    MyPanel panel = new MyPanel();
        
    String black = "-fx-background-color: Black";
    String green = "-fx-background-color: Green";

    @Override
    public void start(Stage primaryStage) {
        

        primaryStage.setTitle("LightsFx Application!");
        BorderPane root = new BorderPane();
       
        MyPanel myPanel = new MyPanel();
        myPanel.placingButtons(myPanel.gridPane);
        root.setCenter(myPanel.gridPane());
        root.setBottom(myPanel.resetPanel());
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}


