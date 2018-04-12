package com.mypackage;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
public class MyLabel extends Label{
    MyLabel(String s){
        super(s);
        setTextFill(Color.web("#0099ff"));
    }
}
