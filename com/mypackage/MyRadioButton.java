package com.mypackage;
import javafx.scene.paint.Color;
import javafx.scene.control.RadioButton;
public class MyRadioButton extends RadioButton{
    MyRadioButton(String s){
        super(s);
        setTextFill(Color.web("#0099ff"));
        setStyle("-fx-background-color: #000000;-fx-mark-color: #0099FF;-fx-color: #000000;");
    }
}

