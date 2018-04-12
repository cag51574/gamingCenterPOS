package com.mypackage;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import java.util.Scanner;
import java.io.IOException;
import java.io.*;
public class SearchResultsPane extends MyGridPane{
    Stage stage;
    MyButton goBack = new MyButton("Go Back"){{
        setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                stage.setScene(new Scene(new SearchPane(stage)));
            }
        });
    }};

    MyButton addTime = new MyButton("Add Time"){{

        setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                stage.setScene(new Scene(new SearchPane(stage)));
            }
        });
    }};

    MyButton deleteUser = new MyButton("Delete User"){{
        setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                delete();
            }
        });
    }};

    MyLabel l1 = new MyLabel("");
    MyLabel l2 = new MyLabel("");
    MyLabel l3 = new MyLabel("");
    MyLabel l4 = new MyLabel("");
    MyLabel l5 = new MyLabel("");
    MyLabel l6 = new MyLabel("");
    MyLabel l7 = new MyLabel("");
    MyLabel l8 = new MyLabel("");
    MyLabel l9 = new MyLabel("");
    MyLabel l10 = new MyLabel("");
    MyLabel b1 = new MyLabel("First Name:\t\t\t");
    MyLabel b2 = new MyLabel("Last Name: \t\t");
    MyLabel b3 = new MyLabel("Phone Number: ");
    MyLabel b4 = new MyLabel("Email Address:\t\t");
    MyLabel b5 = new MyLabel("DL Number:\t\t\t" );
    MyLabel b6 = new MyLabel("Store Card Number:    ");
    MyLabel b7 = new MyLabel("Data Created:\t\t");
    MyLabel b8 = new MyLabel("Time Purchaced:\t");
    MyLabel b9 = new MyLabel("Hours Left:\t");
    MyLabel b10 = new MyLabel("Minutes Left:\t");

    SearchResultsPane(Stage stage,String fname,
                      String lname,String phoneNumber,
                      String email,String dlNumber,
                      String scn, String date,
                      String timePurchaced,String timeLeftInHours,
                      String timeLeftInMinutes){
        super();
        this.stage = stage;
        add(new Label("              "),0,0);
        add(new Label("       "),3,0);
        add(new Label(""),0,3);
        add(new Label(""),0,5);
        add(new Label(""),0,7);
        add(new Label(""),0,9);
        add(new Label(""),0,11);
        add(new Label(""),0,13);
        add(new Label(""),0,15);
        l1.setText(fname);
        l2.setText(lname);
        l3.setText(phoneNumber);
        l4.setText(email);
        l5.setText(dlNumber);
        l6.setText(scn);
        l7.setText(date);
        l8.setText(timePurchaced);
        l9.setText(timeLeftInHours);
        l10.setText(timeLeftInMinutes);
        add(b1,1,2);
        add(b2,4,2);
        add(b3,1,4);
        add(b4,1,6);
        add(b5,1,8);
        add(b6,4,8);
        add(b7,1,10);
        add(b8,1,12);
        add(b9,1,14);
        add(b10,4,14);
        add(l1,2,2);
        add(l2,5,2);
        add(l3,2,4);
        add(l4,2,6);
        add(l5,2,8);
        add(l6,5,8);
        add(l7,2,10);
        add(l8,2,12);
        add(l9,2,14);
        add(l10,5,14);
        add(new Label(""),1,15);
        add(goBack,1,16);
        add(addTime,2,16);
        add(deleteUser,4,16);
    }

    protected void delete(){
        try{
            File file = new File("com/mypackage/users.txt");
            Scanner sc = new Scanner(file);
            String line = "", oldtext = "";
            while(sc.hasNext()){
                String lab1 = sc.next();
                String fname = sc.next();
                String lab2 = sc.next();
                String lname = sc.next();
                String lab3 = sc.next();
                String phoneNumber = sc.next();
                String lab4 = sc.next();
                String email = sc.next();
                String lab5 = sc.next();
                String dl = sc.next();
                String lab6 = sc.next();
                String scn = sc.next();
                String lab7 = sc.next();
                String date = sc.next();
                String lab8 = sc.next();
                String timePurchased = sc.next();
                String lab9 = sc.next();
                String lab10 = sc.next();//TimeOfPurchase
                String lab11 = sc.next();
                String lab12 = sc.next();//TimeElapsedSincePurchase
                String lab13 = sc.next();
                String timeLeftInHours = sc.next();
                String lab14 = sc.next();
                String timeLeftInMinutes = sc.next();
                if(!date.equals(l7.getText())){
                    oldtext += lab1 + " " + fname + "\r\n";
                    oldtext += lab2 + " " + lname + "\r\n";
                    oldtext += lab3 + " " + phoneNumber + "\r\n";
                    oldtext += lab4 + " " + email + "\r\n";
                    oldtext += lab5 + " " + dl + "\r\n";
                    oldtext += lab6 + " " + scn+ "\r\n";
                    oldtext += lab7 + " " + date + "\r\n";
                    oldtext += lab8 + " " + timePurchased + "\r\n";
                    oldtext += lab9 + " " + lab10 + "\r\n";
                    oldtext += lab11 + " " + lab12 + "\r\n";
                    oldtext += lab13 + " " + timeLeftInHours + "\r\n";
                    oldtext += lab14 + " " + timeLeftInMinutes + "\r\n";
                }
            }
            FileWriter fw2 = new FileWriter("com/mypackage/users.txt",false);
            BufferedWriter bw2 = new BufferedWriter(fw2); 
            PrintWriter out2 = new PrintWriter(bw2);
            out2.println(oldtext);
            bw2.close();
        }catch(IOException ex){ex.printStackTrace();}
    }

}
