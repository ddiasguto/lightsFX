package com.example.lightsfx;
import com.example.lightsfx.panel.MyPanel;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
        VBox vBox = new VBox();
        vBox.getChildren().addAll(myPanel.gridPane(),myPanel.resetPanel());
        vBox.setAlignment(Pos.CENTER);
        root.setCenter(vBox);
        
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}


