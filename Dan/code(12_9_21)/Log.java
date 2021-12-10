package p_p_3;

import java.io.FileWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Random;

import java.time.LocalDate;

public class Log extends Cart{

    private static String fileName = "C:\\Users\\Epps\\Desktop\\School\\Fall-2021\\CS _234\\project_phase_3\\resources\\log.txt";

    public static void readLog(){

        System.out.println("\n--------------- PURCHASE LOG ---------------");

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){

            String line;

            while ((line = br.readLine()) != null){

                System.out.println(line);

            }

        }
        catch (Exception e){

            System.out.println("An error occured, please try again.");

        }

    }

    public static boolean createFile()
    
    {   
        boolean checking =false;

        try{
        	
        	File theLog = new File(fileName);
            if (theLog.createNewFile()){

                checking=true;
                
            }

            else{

                checking = true;

            }
        }
        catch (Exception e){

            System.out.println("An error occured, please try again.");
 
        }
        return checking;
    }

    public static void addToLog(String contents)
    {

        try{
        	
            FileWriter myWriter = new FileWriter(fileName, true);

            LocalDate theDate = LocalDate.now();
            Random rand = new Random();
            double price = rand.nextInt(100);

            myWriter.write(theDate + "\t" + contents + "\t" + "   $" +price + "\r");
            myWriter.close();
            System.out.println(contents + " saved to log!");
        }
        catch (Exception e){

            System.out.println("An error occured, please try again.");

        }

    }

}
