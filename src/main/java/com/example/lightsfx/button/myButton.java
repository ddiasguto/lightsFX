package com.example.lightsfx.button;

import javafx.scene.control.Button;

public class myButton extends Button {
   public Boolean on;
    
    public myButton(){
        on = false;
        this.setMinHeight(60);
        this.setMinWidth(60);
    }
    
    public void switchOn(){
        this.on = !this.on;
    }

    public void setOnValue(Boolean aux){
        this.on = aux;
    }
}
