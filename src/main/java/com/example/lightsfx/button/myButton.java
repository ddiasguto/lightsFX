package com.example.lightsfx.button;

import javafx.scene.control.Button;

public class myButton extends Button {
   public Boolean on;
    
    public myButton(){
        on = false;
    }
    
    public void switchOn(){
        this.on = !this.on;
    }

    public void setOnValue(Boolean value){
        this.on = value;
    }
}
