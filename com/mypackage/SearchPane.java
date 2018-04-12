package com.mypackage;
import javafx.event.ActionEvent;
import java.util.Date;
import java.util.Scanner;
import java.io.IOException;
import java.io.*;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
public class SearchPane extends MyGridPane{
    Stage stage;
    
    //SearchPane
    ToggleGroup group = new ToggleGroup();
    MyRadioButton fnameBtn = new MyRadioButton("First Name"){{ setToggleGroup(group);}};
    MyRadioButton lnameBtn = new MyRadioButton("Last Name"){{setToggleGroup(group);}};
    MyRadioButton phoneBtn = new MyRadioButton("Phone Number"){{setToggleGroup(group);}};
    MyRadioButton emailBtn = new MyRadioButton("Email"){{setToggleGroup(group);}};
    MyRadioButton dlBtn = new MyRadioButton("DL Number"){{setToggleGroup(group);}};
    MyRadioButton storeCardNumberBtn = new MyRadioButton("Store Card Number"){{setToggleGroup(group);}};
    MyLabel l12 = new MyLabel("What would you like to search by?\n");
    MyTextField searchTf = new MyTextField();
    //SearchPane
    MyButton goBack3 = new MyButton("Go Back"){{
        setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                stage.setScene(new Scene(new MainPane(stage)));
            }
        });
    }};
    //SearchPane
    //Searches based on info and toggle. Does not check for duplicates.
    MyButton searchUser = new MyButton("Search"){{
        setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                String flag = "fn";
                if(fnameBtn.isSelected()){
                    flag = "fn";
                }
                if(lnameBtn.isSelected()){
                    flag = "ln";
                }
                if(phoneBtn.isSelected()){
                    flag = "p";
                }
                if(emailBtn.isSelected()){
                    flag = "e";
                }
                if(dlBtn.isSelected()){
                    flag = "d";
                }
                if(storeCardNumberBtn.isSelected()){
                    flag = "s";
                }
                search(flag,searchTf.getText());
            }
        });
    }};
    //SearchPane
    MyButton clear2 = new MyButton("Clear text field"){{
        setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                searchTf.clear();
            }
        });
    }};
    
    //Adding to searchPane
    SearchPane(Stage stage){
        super();
        this.stage = stage;
        add(new Label("          "),0,0);
        add(new Label(""),0,1);
        add(l12,1,2);
        add(new Label(""),0,3);
        add(new Label(""),0,3);
        add(fnameBtn,1,4);
        add(lnameBtn,2,4);
        add(new Label(""),0,5);
        add(phoneBtn,1,6);
        add(emailBtn,2,6);
        add(new Label(""),0,7);
        add(dlBtn,1,8);
        add(storeCardNumberBtn,2,8);
        add(new Label(""),0,9);
        add(new Label(""),0,10);
        add(searchTf,1,11);
        add(new Label(""),0,12);
        add(new Label(""),0,13);
        add(goBack3,1,14);
        add(searchUser,2,14);
        add(clear2,3,14);
    }

    private void search(String flag1, String s){
        update();
        try{
            File file = new File("com/mypackage/users.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){

                sc.next();
                String fname = sc.next();
                sc.next();
                String lname = sc.next();
                sc.next();
                String phoneNumber = sc.next();
                sc.next();
                String email = sc.next();
                sc.next();
                String dl = sc.next();
                sc.next();
                String scn = sc.next();
                sc.next();
                String date = sc.next();
                sc.next();
                String timePurchased = sc.next();
                sc.next();
                sc.next();//TimeOfPurchase
                sc.next();
                sc.next();//TimeElapsedSincePurchase
                sc.next();
                String timeLeftInHours = sc.next();
                sc.next();
                String timeLeftInMinutes = sc.next();
                

                Boolean flag2 = false;
                String[] info = {fname,lname,phoneNumber,email,dl,scn,date,timePurchased,timeLeftInHours,timeLeftInMinutes};
                switch(flag1){
                    case "fn": 
                        if(fname.equals(s)==true) flag2 = true;
                        break;
                    case "ln": 
                        if(lname.equals(s)==true) flag2 = true;
                        break;
                    case "p": 
                        if(phoneNumber.equals(s)==true) flag2 = true;
                        break;
                    case "e": 
                        if(email.equals(s)==true) flag2 = true;
                        break;
                    case "d": 
                        if(dl.equals(s)==true) flag2 = true;
                        break;
                    case "s": 
                        if(scn.equals(s)==true) flag2 = true;
                        break;
                    }
                if(flag2){
                    stage.setScene(new Scene(new SearchResultsPane(stage,fname,lname,phoneNumber,email,dl,scn,date,timePurchased,timeLeftInHours,timeLeftInMinutes)));
                    
                    break;
                    //SearchResults
                }        
            }           
        }catch(Exception ex){ex.printStackTrace();}
    }

} 
