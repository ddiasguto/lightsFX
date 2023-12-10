package com.example.lightsfx.panel;

import com.example.lightsfx.button.myButton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class myPanel {


    
    public HBox addHBox() {

        myButton btn1 = new myButton();
        myButton btn2 = new myButton();
        myButton btn3 = new myButton();
        myButton btn4 = new myButton();
        myButton btn5 = new myButton();

        HBox hbox = new HBox();

        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);


        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(btn2.on){
                    btn2.setStyle("-fx-background-color: Black");
                }
                else{
                    btn2.setStyle("-fx-background-color: Green");
                }
                if(btn3.on){
                    btn3.setStyle("-fx-background-color: Black");
                }
                else{
                    btn3.setStyle("-fx-background-color: Green");
                }
                btn2.switchOn(); 
                btn3.switchOn();
            }
        });



        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {
                if(btn1.on){
                    btn1.setStyle("-fx-background-color: Black");
                }
                else{
                    btn1.setStyle("-fx-background-color: Green");
                }
                if(btn3.on){
                    btn3.setStyle("-fx-background-color: Black");
                }
                else{
                    btn3.setStyle("-fx-background-color: Green");
                }
                btn1.switchOn();
                btn3.switchOn();
            }

        });



        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(btn2.on){
                    btn2.setStyle("-fx-background-color: Black");
                }
                else{
                    btn2.setStyle("-fx-background-color: Green");
                }
                if(btn1.on){
                    btn1.setStyle("-fx-background-color: Black");
                }
                else{
                    btn1.setStyle("-fx-background-color: Green");
                }
                btn2.switchOn();
                btn1.switchOn();
            }
        });

        hbox.getChildren().addAll(btn1,btn2,btn3);
        hbox.setAlignment(Pos.CENTER);


        return hbox;
    }}