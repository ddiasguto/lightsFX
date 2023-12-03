package com.example.lightsfx;
/*
 Written by Danniel Dias Augusto.
 */


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

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Button btn2 = new Button();
    Button btn1 = new Button();
    Button btn3 = new Button();
    Boolean b1=false, b2=false, b3=false;


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ding Application!");
        BorderPane root = new BorderPane();

        btn1.setMinWidth(30);
        btn1.setMinHeight(30);
        btn2.setMinWidth(30);
        btn2.setMinHeight(30);
        btn3.setMinWidth(30);
        btn3.setMinHeight(30);
        root.setCenter(addHBox());

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);


        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(b2){
                    btn2.setStyle("-fx-background-color: Black");
                }
                else{
                    btn2.setStyle("-fx-background-color: Green");
                }
                if(b3){
                    btn3.setStyle("-fx-background-color: Black");
                }
                else{
                    btn3.setStyle("-fx-background-color: Green");
                }
                b2 = !b2;
                b3 =!b3;
            }
        });



        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {
                if(b1){
                    btn1.setStyle("-fx-background-color: Black");
                }
                else{
                    btn1.setStyle("-fx-background-color: Green");
                }
                if(b3){
                    btn3.setStyle("-fx-background-color: Black");
                }
                else{
                    btn3.setStyle("-fx-background-color: Green");
                }
                b1 = !b1;
                b3 =!b3;
            }

        });



        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(b2){
                    btn2.setStyle("-fx-background-color: Black");
                }
                else{
                    btn2.setStyle("-fx-background-color: Green");
                }
                if(b1){
                    btn1.setStyle("-fx-background-color: Black");
                }
                else{
                    btn1.setStyle("-fx-background-color: Green");
                }
                b2 = !b2;
                b1 =!b1;
            }
        });

        hbox.getChildren().addAll(btn1,btn2,btn3);
        hbox.setAlignment(Pos.CENTER);


        return hbox;
    }
}


