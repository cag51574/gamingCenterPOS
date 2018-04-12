package com.mypackage;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.text.*;
public class AddUserSuccessPane extends MyGridPane{
    Stage stage;
    MyButton goBack = new MyButton("Go Back"){{
        setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                stage.setScene(new Scene(new AddUserPane(stage)));
            }
        });
    }};

    MyLabel success1 = new MyLabel("User Account"){{
        setFont(Font.font("Verdana", FontWeight.BOLD, 35));
    }};
    MyLabel success2 = new MyLabel("Created Successfully!"){{
        setFont(Font.font("Verdana", FontWeight.BOLD, 35));
    }};

    AddUserSuccessPane(Stage stage){
        super();
        this.stage = stage;
        add(new Label("                "),0,0);
        add(new Label(""),0,1);
        add(new Label(""),0,2);
        add(success1,1,3);
        add(success2,1,4);
        add(new Label(""),0,5);
        add(new Label(""),0,6);
        add(goBack,1,7);
    }

}
