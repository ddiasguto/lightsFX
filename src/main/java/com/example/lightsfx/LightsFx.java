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
        myButton btn00 = new myButton();
        myButton btn01 = new myButton();
        myButton btn02 = new myButton();
        myButton btn03 = new myButton();
        myButton btn04 = new myButton();
        myButton btn10 = new myButton();
        myButton btn11 = new myButton();
        myButton btn12 = new myButton();
        myButton btn13 = new myButton();
        myButton btn14 = new myButton();
        myButton btn20 = new myButton();
        myButton btn21 = new myButton();
        myButton btn22 = new myButton();
        myButton btn23 = new myButton();
        myButton btn24 = new myButton();
        myButton btn30 = new myButton();
        myButton btn31 = new myButton();
        myButton btn32 = new myButton();
        myButton btn33 = new myButton();
        myButton btn34 = new myButton();
        myButton btn40 = new myButton();
        myButton btn41 = new myButton();
        myButton btn42 = new myButton();
        myButton btn43 = new myButton();
        myButton btn44 = new myButton();



        final myButton[][] buttons = {
            {btn00,btn01,btn02,btn03,btn04},
            {btn10,btn11,btn12,btn13,btn14},
            {btn20,btn21,btn22,btn23,btn24},
            {btn30,btn31,btn32,btn33,btn34},
            {btn40,btn41,btn42,btn43,btn44}
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


