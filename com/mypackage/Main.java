package com.mypackage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stage){

        //Settings for the primary stage
        stage.setTitle("Kelly's Corner");
        stage.setHeight(430);
        stage.setWidth(605);
        
        MainPane mainPane = new MainPane(stage);
        Scene mainScene = new Scene(mainPane);
        //Sets initial pane to main screen
        stage.setScene(mainScene);

        //Shows the whole thing...
        stage.show();
    }//Start
}

