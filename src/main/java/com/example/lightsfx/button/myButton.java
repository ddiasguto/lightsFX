package com.example.lightsfx.button;

import javafx.scene.control.Button;

public class myButton extends Button {
   public Boolean on;
    
    public myButton(){
        on = false;
        this.setMinHeight(30);
        this.setMinWidth(30);
    }
    
    public void switchOn(){
        this.on = !this.on;
    }
}
