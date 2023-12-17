package com.example.lightsfx.panel;
import java.util.Random;

import com.example.lightsfx.button.myButton;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class MyPanel {

    String black = "-fx-background-color: Black";
    String green = "-fx-background-color: Green";

    
    final myButton[][] buttons = {
       {new myButton(),new myButton(),new myButton(),new myButton(),new myButton()},
       {new myButton(),new myButton(),new myButton(),new myButton(),new myButton()},
       {new myButton(),new myButton(),new myButton(),new myButton(),new myButton()},
       {new myButton(),new myButton(),new myButton(),new myButton(),new myButton()},
       {new myButton(),new myButton(),new myButton(),new myButton(),new myButton()}
   };
    public GridPane gridPane = new GridPane();
    public GridPane gridPane() {



        gridPane.setHgap(3); 
        gridPane.setVgap(3); 
        setActions(buttons);

        return gridPane;
    }


    public Button resetPanel(){    
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

   public void placingButtons(GridPane gridPane){       
        int columnCount = 0;
        while(columnCount<5){
            for(int rowCount =0; rowCount<5;rowCount++){
                setButtonInitialValue(buttons[columnCount][rowCount]);
                gridPane.add(buttons[columnCount][rowCount],columnCount,rowCount);
            }   
            columnCount++;
        }
    }

}

