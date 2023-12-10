package com.example.lightsfx;
import com.example.lightsfx.panel.myPanel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LightsFx extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
            myPanel panel = new myPanel();
        
            for(int i=0;i<panel.buttons.length; i++){
                panel.setInitialValue(panel.buttons[i]);
            }
        primaryStage.setTitle("LightsFx Application!");
        BorderPane root = new BorderPane();

       
        root.setCenter(panel.addHBox());

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

}


