package com.example.lightsfx.panel;
import java.util.Random;

import com.example.lightsfx.button.myButton;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class myPanel {

    String black = "-fx-background-color: Black";
    String green = "-fx-background-color: Green";

    myButton btn1 = new myButton();
    myButton btn2 = new myButton();
    myButton btn3 = new myButton();
    myButton btn4 = new myButton();
    myButton btn5 = new myButton();
    public myButton[] buttons = {btn1,btn2,btn3,btn4,btn5};
    public HBox addHBox() {


        HBox hbox = new HBox();

        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);


            for( int i=0;i<buttons.length;i++){
                final int j = i;
                buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(buttons[j].on){
                        buttons[j].setStyle(black);
                    }
                    else{
                        buttons[j].setStyle(green);
                    }
                buttons[j].switchOn();
                }
            });
            }

            hbox.getChildren().addAll(buttons);
            hbox.setAlignment(Pos.CENTER);

        return hbox;
    }

    public void setInitialValue(myButton button){
         Random random = new Random();
        button.setOnValue(random.nextBoolean());
        String color = button.on ? green : black;
         button.setStyle(color);
    }
}

