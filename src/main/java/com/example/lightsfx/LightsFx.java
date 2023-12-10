package com.example.lightsfx;
import com.example.lightsfx.panel.myPanel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LightsFx extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    myPanel panel = new myPanel();
    @Override
    public void start(Stage primaryStage) {
        
        
            for(int i=0;i<panel.buttons.length; i++){
                panel.setInitialValue(panel.buttons[i]);
            }
        primaryStage.setTitle("LightsFx Application!");
        BorderPane root = new BorderPane();

       
        root.setCenter(panel.addHBox());
        root.setBottom(resetPanel(panel));
        

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    private Button resetPanel(myPanel panel){    
        Button btnRed = new Button();
        
        btnRed.setText("New Challenge");
        btnRed.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
               for(int i=0;i<panel.buttons.length; i++){
                panel.setInitialValue(panel.buttons[i]);
            }
            }
        });

        return btnRed;
    } 

}


