package com.mypackage;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
public class MyButton extends Button{
    MyButton(String s){
        super(s);
        setTextFill(Color.web("#0099ff"));
        setStyle("-fx-background-color: #000000;-fx-border-color: #0099FF;");
    }
}
