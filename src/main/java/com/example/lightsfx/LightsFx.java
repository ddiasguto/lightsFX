package com.example.lightsfx;
import java.util.Random;
import com.example.lightsfx.button.myButton;
import com.example.lightsfx.panel.myPanel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LightsFx extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    myPanel panel = new myPanel();
    
String black = "-fx-background-color: Black";
String green = "-fx-background-color: Green";
    @Override
    public void start(Stage primaryStage) {
        

        primaryStage.setTitle("LightsFx Application!");
        BorderPane root = new BorderPane();
        
        GridPane gridPane = new GridPane();
        final myButton[][] buttons = {
            {new myButton(),new myButton(),new myButton(),new myButton(),new myButton()},
            {new myButton(),new myButton(),new myButton(),new myButton(),new myButton()},
            {new myButton(),new myButton(),new myButton(),new myButton(),new myButton()},
            {new myButton(),new myButton(),new myButton(),new myButton(),new myButton()},
            {new myButton(),new myButton(),new myButton(),new myButton(),new myButton()}
        };

        
        
        int columnCount = 0;
        while(columnCount<5){
            for(int rowCount =0; rowCount<5;rowCount++){
                setButtonInitialValue(buttons[columnCount][rowCount]);
                gridPane.add(buttons[columnCount][rowCount],columnCount,rowCount);
            }   
            columnCount++;
        }
        setActions(buttons);
        gridPane.setHgap(3); 
        gridPane.setVgap(3); 
        root.setCenter(gridPane);
        root.setBottom(resetPanel(buttons));


        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
    private void setActions(myButton[][] buttons){
       int i = 0;
        while(i < 5){
            final int rowIndex = i;
        for(int j=0; j<5;j++){
                final int colIndex = j;
            buttons[j][i].setOnAction(new EventHandler<ActionEvent>() {
    
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("button clicked: " + rowIndex + ' ' + colIndex);
                        buttonAction(buttons[colIndex][rowIndex
                        ]);
                    }
                });
            }
            i++;
        }
    }


    private void buttonAction(myButton button){
        String color = button.on ? black : green; 
        button.setStyle(color);
        button.switchOn();
    }


    public void setButtonInitialValue(myButton button){
         Random random = new Random();
        button.setOnValue(random.nextBoolean());
        String color = button.on ? green : black;
        button.setStyle(color);
    }


    private Button resetPanel(myButton[][] buttons){    
        Button resetBtn = new Button();
        
        resetBtn.setText("New Challenge");
        resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                int i=0;
                while(i<5){
                    for(int j=0;j<5;j++){
                        Random random = new Random();
                        buttons[i][j].setOnValue(random.nextBoolean());
                        String color = buttons[i][j].on ? green : black;
                        buttons[i][j].setStyle(color);
                    }
                    i++;
                }
            }
        });

        return resetBtn;
    } 

}


