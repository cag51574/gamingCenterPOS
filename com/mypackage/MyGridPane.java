package com.mypackage;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
public class MyGridPane extends GridPane{
    MyGridPane(){
        super();
        setStyle("-fx-background-color: #000000;");
    }

    protected void update(){
        try(FileWriter fw = new FileWriter("com/mypackage/users.txt",true); 
            BufferedWriter bw = new BufferedWriter(fw); 
            PrintWriter out = new PrintWriter(bw);
            Scanner sc = new Scanner(new File("com/mypackage/users.txt"));) {
            File f = new File("com/mypackage/users.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = "", oldtext = "";
            Date date = new Date();
            String timePurchased = "0";
            String timeOfPurchase = "0";
            String timeElapsed = "0";
            String hoursLeft = "0";
            String minutesLeft = "0";
            while((line = br.readLine()) != null) {
                String currentTime = date.getTime() + "";
                String[] parts = line.split(" ");
                if(parts[0].equals("TimePurchased:")){
                    timePurchased = parts[1];
                }
                if(parts[0].equals("TimeOfPurchase:")){
                    timeOfPurchase = parts[1];
                }
                if(parts[0].equals("TimeElapsedSincePurchase:")){
                    timeElapsed = Long.toString(Long.parseLong(currentTime) - Long.parseLong(timeOfPurchase));
                    line = parts[0] + " " + timeElapsed;
                }
                if(parts[0].equals("HoursLeft:")){
                    try{
                        hoursLeft =  Long.toString( Long.parseLong(timePurchased) -(Long.parseLong(timeElapsed) / (1000 * 60 * 60 ))-1);
                        if(Integer.parseInt(hoursLeft) < 0){
                            hoursLeft = "none";
                        }
                    }catch(Exception ex){hoursLeft = "none";}
                    line = parts[0] + " " + hoursLeft;
                }
                if(parts[0].equals("MinutesLeft:")){
                    try{
                        minutesLeft = Long.toString((Long.parseLong(timePurchased) * 60) - (Long.parseLong(timeElapsed) / (1000 * 60 )) - (Long.parseLong(hoursLeft)*60));
                        if(Integer.parseInt(hoursLeft) < 0){
                            minutesLeft = "none";
                        }
                    }catch(Exception ex){ minutesLeft = "none";}
                    line = parts[0] + " " + minutesLeft;
                }
                oldtext += line + "\r\n";
            }
            //fw.write(oldtext);
            br.close();

            FileWriter fw2 = new FileWriter("com/mypackage/users.txt",false);
            BufferedWriter bw2 = new BufferedWriter(fw2); 
            PrintWriter out2 = new PrintWriter(bw2);
            out2.println(oldtext);
            bw2.close();
        }catch(IOException ex){ex.printStackTrace();}
    }
}
        
