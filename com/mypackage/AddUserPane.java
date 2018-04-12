package com.mypackage;
import java.io.IOException;
import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class AddUserPane extends MyGridPane{

    String[] newUserInfo = new String[7];
    Stage stage;
    Scene scene;
    
    //addUserPane
    MyTextField tf1 = new MyTextField();
    MyTextField tf2 = new MyTextField();
    MyTextField tf3 = new MyTextField();
    MyTextField tf4 = new MyTextField();
    MyTextField tf5 = new MyTextField();
    MyTextField tf6 = new MyTextField();
    MyTextField tf7 = new MyTextField();

    //addUserPane
    MyButton clear1 = new  MyButton("Clear all text fields"){{
        setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                tf1.clear();
                tf2.clear();        
                tf3.clear();
                tf4.clear();
                tf5.clear();
                tf6.clear();
                tf7.clear();
            }
        });
    }};

    //addUserPane
    MyButton addUserBtn = new MyButton("Add New User"){{
        setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                try{
                    for(int i = 0; i < 7;i++){
                        newUserInfo[i] = "none";
                        switch (i){
                            case 0: if(tf1.getText().isEmpty()== false) newUserInfo[i] = tf1.getText();
                                        break;
                            case 1: if(tf2.getText().isEmpty()== false) newUserInfo[i] = tf2.getText();
                                        break;
                            case 2: if(tf3.getText().isEmpty()== false) newUserInfo[i] = tf3.getText();
                                        break;
                            case 3: if(tf4.getText().isEmpty()== false) newUserInfo[i] = tf4.getText();
                                        break;
                            case 4: if(tf5.getText().isEmpty()== false) newUserInfo[i] = tf5.getText();
                                        break;
                            case 5: if(tf6.getText().isEmpty()== false) newUserInfo[i] = tf6.getText();
                                        break;
                            case 6: if(tf7.getText().isEmpty()== false) newUserInfo[i] = tf7.getText();
                                        break;
                        }
                    }
                    addUser(newUserInfo);
                }catch(Exception ex){
                    //stage.setScene(incorrectFormat);
                }
            }
        });
    }};
    
    /*
    //IncorrectFormatPane
    MyButton goBack2 = new MyButton("Go Back");
    goBack2.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle(ActionEvent e) {
            stage.setScene(addUserScene);
        }
    });
    */

    //addUserPane
    MyLabel l1 = new MyLabel("Enter a first name:");
    MyLabel l2 = new MyLabel("Enter a last name:");
    MyLabel l3 = new MyLabel("Enter a phone number:");
    MyLabel l4 = new MyLabel("Enter an email:");
    MyLabel l5 = new MyLabel("Enter a DL number:");
    MyLabel l6 = new MyLabel("Enter a store card number:    ");
    MyLabel l7 = new MyLabel("Enter a time:");
    
    //addUserPane
    MyButton goBack1 = new MyButton("Go Back"){{
        setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                stage.setHeight(430);
                stage.setWidth(605);
                stage.setScene(new Scene(new MainPane(stage)));
            }
        });
    }};


    AddUserPane(Stage stage){
        super();
        this.stage = stage;
        this.scene= scene;
        add(new Label("          "),0,0);
        add(l1,1,1);
        add(tf1, 2,1);
        add(new Label(""),0,2);
        add(l2,1,3);
        add(tf2, 2,3);
        add(new Label(""),0,4);
        add(l3,1,5);
        add(tf3, 2,5);
        add(new Label(""),0,6);
        add(l4,1,7);
        add(tf4, 2,7);
        add(new Label(""),0,8);
        add(l5,1,9);
        add(tf5, 2,9);
        add(new Label(""),0,10);
        add(l6,1,11);
        add(tf6, 2,11);
        add(new Label(""),0,12);
        add(l7,1,13);
        add(tf7, 2,13);
        add(new Label(""),1,14);
        add(new Label(""),1,15);
        add(goBack1, 1,16);
        add(addUserBtn, 2,16);
        add(clear1, 3,16);
    }

    private void addUser(String[] s){
        try(FileWriter fw = new FileWriter("com/mypackage/users.txt", true); 
            BufferedWriter bw = new BufferedWriter(fw); 
            PrintWriter out = new PrintWriter(bw);
            Scanner sc = new Scanner(new File("com/mypackage/users.txt"));) {
            
            Boolean flag = true;
            //Check for duplicate phone numbers
            /*
            for(int i = 0; i < s.length-1;i++){
                try{
                    if(sc.hasNext() && flag){
                        if(sc.next().equals(s[i])){
                            flag =false; 
                        }
                    }
                }catch(Exception ex) {ex.printStackTrace(); }
            }
            */
            
            if(flag){
                for(int i = 0; i < s.length;i++){
                    switch (i){
                        case 0: out.println("FirstName: " + s[i]);
                                break;
                        case 1: out.println("LastName: " + s[i]);
                                break;
                        case 2: out.println("PhoneNumber: " + s[i]);
                                break;
                        case 3: out.println("Email: " + s[i]);
                                break;
                        case 4: out.println("DLNumber: " + s[i]);
                                break;
                        case 5: out.println("StoreCardNumber: " + s[i]);
                                //Date Created
                                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
                                Date date = new Date();
                                out.println("DateCreated: " + dateFormat.format(date)); //2014/08/06 15:59:48
                                break;
                        case 6: out.println("TimePurchased: " + s[i]);
                                date = new Date();
                                out.println("TimeOfPurchase: " + date.getTime());
                                out.println("TimeElapsedSincePurchase: " + date.getTime());
                                out.println("HoursLeft: " + s[i]);
                                try{
                                    out.println("MinutesLeft: " + (Integer.parseInt(s[i]) * 60));
                                }catch(Exception ex){
                                    out.println("MinutesLeft: 0");
                                }
                                out.println();
                                stage.setScene(new Scene(new AddUserSuccessPane(stage)));

                                break;

                    }
                }
            }else{
//                errorMesg.setText("There was a duplicate phone number");}
                }

        } catch (IOException ex) {
 //           errorMesg.setText("Something went wrong while adding a user.");

        }
    }
    /*
    //Adds a new user
    private void addUser(String name, int phoneNumber, String email, int dlNumber, int storeCardNumber,int time){
        try{
            File file = new File("users.txt");
            Scanner sc = new Scanner(file);
            Boolean flag = false;
            while(sc.hasNext()){
                try{
                    if(sc.next().equals(Integer.toString(phoneNumber))){
                        flag = true;
                        break;
                    }
                }catch(Exception ex){ex.printStackTrace();}
            }
            if(flag == false){
                FileWriter fWriter = new FileWriter (file, true);
                PrintWriter pWriter = new PrintWriter (fWriter);
                pWriter.println(name);
                pWriter.println(phoneNumber);
                pWriter.println(email);
                pWriter.println(dlNumber);
                pWriter.println(storeCardNumber);
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
                Date date = new Date();
                pWriter.println(dateFormat.format(date)); //2014/08/06 15:59:48
                pWriter.println(time);
                pWriter.println();
                pWriter.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    */
}
