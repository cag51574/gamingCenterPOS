package com.mypackage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.stage.Stage;          
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.scene.control.ScrollPane;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;
public class AllUsersPane extends MyGridPane{
    Stage stage;

    MyButton goBack = new MyButton("Go Back"){{
        setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                stage.setHeight(430);
                stage.setWidth(605);
                stage.setScene(new Scene(new MainPane(stage)));
            }
        });
    }};

    MyButton refreshBtn = new MyButton("Refresh"){{
        setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                refresh();
            }
        });
    }};

    MyGridPane buttonGrid = new MyGridPane(){{
        add(goBack,0,0);
        add(new MyLabel("           "),1,0);
        add(refreshBtn,2,0);
    }};

    AllUsersPane(Stage stage){
        super();
        this.stage = stage;
        add(new Label("   "),0,0);
        add(buttonGrid,1,1);
        add(new MyLabel("       "),1,2);
        refresh();
        add(s1,1,3);

    }

    ScrollPane s1 = new ScrollPane(){{
        setStyle("-fx-background-color: #000000;-fx-border-color:#0099FF;");
        setHbarPolicy(ScrollBarPolicy.NEVER);
    }};

    private void refresh(){
        update();
        MyGridPane grid = new MyGridPane(){{
            setStyle("-fx-background-color: #000000;");
        }};
        MyLabel fnLab = new MyLabel("First Name"){{
            setUnderline(true);
        }};
        MyLabel lnLab = new MyLabel("Last Name"){{
            setUnderline(true);
        }};
        MyLabel eLab = new MyLabel("Email"){{
            setUnderline(true);
        }};
        MyLabel pLab = new MyLabel("Phone"){{
            setUnderline(true);
        }};
        MyLabel dlLab = new MyLabel("DL Number"){{
            setUnderline(true);
        }};
        MyLabel scnLab = new MyLabel("Store Card Number"){{
            setUnderline(true);
        }};
        MyLabel dateLab = new MyLabel("Date Created"){{
            setUnderline(true);
        }};
        MyLabel hLab = new MyLabel("Hours"){{
            setUnderline(true);
        }};
        MyLabel mLab = new MyLabel("Minutes"){{
            setUnderline(true);
        }};
        grid.add(fnLab,0,0);
        grid.add(new MyLabel("      "),1,0);
        grid.add(lnLab,2,0);
        grid.add(new MyLabel("      "),3,0);
        grid.add(eLab,4,0);
        grid.add(new MyLabel("      "),5,0);
        grid.add(pLab,6,0);
        grid.add(new MyLabel("      "),7,0);
        grid.add(dlLab,8,0);
        grid.add(new MyLabel("      "),9,0);
        grid.add(scnLab,10,0);
        grid.add(new MyLabel("      "),11,0);
        grid.add(dateLab,12,0);
        grid.add(new MyLabel("      "),13,0);
        grid.add(hLab,14,0);
        grid.add(new MyLabel("      "),15,0);
        grid.add(mLab,16,0);
        grid.add(new MyLabel("              "),17,0);
 
        try{
            File file = new File("com/mypackage/users.txt");
            Scanner sc = new Scanner(file);
            int count = 1;
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
                //TimeOfPurchase
                sc.next();
                sc.next();
                //TimeElapsedSincePurchase
                sc.next();
                sc.next();
                String hoursLeft = sc.next();
                sc.next();
                String minutesLeft = sc.next();
                
                grid.add(new MyLabel(fname),0,count);
                grid.add(new MyLabel(lname),2,count);
                grid.add(new MyLabel(email),4,count);
                grid.add(new MyLabel(phoneNumber),6,count);
                grid.add(new MyLabel(dl),8,count);
                grid.add(new MyLabel(scn),10,count);
                grid.add(new MyLabel(date),12,count);
                grid.add(new MyLabel(hoursLeft),14,count);
                grid.add(new MyLabel(minutesLeft),16,count);
                count++;
            }           
        }catch(Exception ex){ex.printStackTrace();}
        s1.setContent(grid);
    }
}
