package com.mypackage;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.stage.Stage;
public class MainPane extends MyGridPane{
    Stage stage;
    //
    //MainPane
    Logo iv1 = new Logo();
    MyLabel welcome = new MyLabel("Welcome\nto\nKelly's Corner"){{
        setStyle("-fx-text-alignment: center;");
        setPadding(new Insets(0,30,10,55));
    }};
    
    //MainPane
    MyButton time = new MyButton("Time"){{ setMinSize(200,200); 
        setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                stage.setScene(new Scene(new TimerPane(stage)));
            }
        });
    }};

    //MainPane
    MyButton searchBtn = new MyButton("Search"){{ setMinSize(200,200); 
        setOnAction(new EventHandler<ActionEvent>(){
            @Override 
            public void handle(ActionEvent e) {
                stage.setScene(new Scene(new SearchPane(stage)));
            }
        });
    }};

    //MainPane
    MyButton addNew = new MyButton("Add a new user"){{ setMinSize(200,200);
        setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {  
                stage.setHeight(490);
                stage.setWidth(605);
                stage.setScene(new Scene(new AddUserPane(stage)));
            }
        });  
    }};

    //MainPane
    MyButton allUsers = new MyButton("View all users"){{ setMinSize(200,200); 
        setOnAction(new EventHandler<ActionEvent>(){
            @Override 
            public void handle(ActionEvent e) {
                stage.setHeight(430);
                stage.setWidth(900);
                stage.setScene(new Scene(new AllUsersPane(stage)));
            }
        });
    }};

    //MainPane
    MainPane(Stage stage){
        super();
        this.stage = stage;
        add(addNew, 0, 0);
        add(searchBtn, 0, 1);
        add(iv1,1,0);
        add(welcome,1,1);
        add(time, 2, 0);
        add(allUsers, 2, 1);
    }

}
