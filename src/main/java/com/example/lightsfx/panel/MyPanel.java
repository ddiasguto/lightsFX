package com.example.lightsfx.panel;
import java.util.Random;
import com.example.lightsfx.button.myButton;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
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
    private int colIndex;
    
    public GridPane gridPane() {
        gridPane.setHgap(3); 
        gridPane.setVgap(3); 
        setActions(buttons);
        gridPane.setPadding(new Insets(15, 12, 15, 12));
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }


    public Button resetPanel(){    
        Button resetBtn = new Button();
        
        
        resetBtn.setText("New Challenge");
        resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    setPanelInitialSetup();
                    System.out.println("New Challenge Settled!");
            }
        });

        return resetBtn;
    } 

     public Button invertButtons(){    
        Button invertBtn = new Button();
        
        
        invertBtn.setText("Invert All.");
        invertBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                int i=0;
                while(i<5){
                    for(int j=0;j<5;j++){
                        buttonAction(buttons[i][j]);
                    }
                    i++;
                }
                System.out.println("Buttons state changed!");
            }
        });

        return invertBtn;
    } 

    private void setActions(myButton[][] buttons){
        int i = 0;
         while(i < 5){
              int rowIndex = i;
         for(int j=0; j<5;j++){
            int colIndex = j;
             buttons[j][i].setOnAction(new EventHandler<ActionEvent>() {
     
                     @Override
                     public void handle(ActionEvent event) {
                         System.out.println("button clicked: " + rowIndex + ' ' + colIndex);
                         buttonAction(buttons[colIndex][rowIndex]);
                         if(colIndex-1>=0 && colIndex-1<5){
                            buttonAction(buttons[colIndex-1][rowIndex]);
                         }
                         if(colIndex+1>=0 && colIndex+1<5){
                            buttonAction(buttons[colIndex+1][rowIndex]);
                         }
                         if(rowIndex-1>=0 && rowIndex-1<5){
                            buttonAction(buttons[colIndex][rowIndex-1]);
                         }
                         if(rowIndex+1>=0 && rowIndex+1<5){
                            buttonAction(buttons[colIndex][rowIndex+1]);
                         }
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

    public void setPanelInitialSetup(){
        int i=0;
         while(i < 5){
                    int rowIndex = i;
                    for(int j=0; j<5;j++){
                        int colIndex = j;
                        Random random = new Random();
                        int aux;
                        if(random.nextBoolean()){
                        System.out.println("button changed: " + colIndex + ' ' + rowIndex);
                         buttonAction(buttons[colIndex][rowIndex]);
                         if(colIndex-1>=0 && colIndex-1<5){
                            buttonAction(buttons[colIndex-1][rowIndex]);
                            aux = colIndex-1;
                            System.out.println("Neighbor changed:" + aux+ " " + rowIndex );
                         }
                         if(colIndex+1>=0 && colIndex+1<5){
                            buttonAction(buttons[colIndex+1][rowIndex]);
                            aux = colIndex+1;
                            System.out.println("Neighbor changed:" + aux + " " + rowIndex );
                         }
                         if(rowIndex-1>=0 && rowIndex-1<5){
                            buttonAction(buttons[colIndex][rowIndex-1]);
                            aux = rowIndex-1;
                            System.out.println("Neighbor changed:" + colIndex + " " + aux );
                         }
                         if(rowIndex+1>=0 && rowIndex+1<5){
                            buttonAction(buttons[colIndex][rowIndex+1]);
                            aux = rowIndex+1;
                            System.out.println("Neighbor changed:" + colIndex + " " + aux );
                            
                        }
                        }
                    }
                    i++;
                }
   }

   public void placingButtons(GridPane gridPane){       
        int columnCount = 0;
        while(columnCount<5){
            for(int rowCount =0; rowCount<5;rowCount++){
                gridPane.add(buttons[columnCount][rowCount],columnCount,rowCount);
            }   
            columnCount++;
        }

    }

}

